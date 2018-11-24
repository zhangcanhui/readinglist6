package hnu.controller;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.PersonInfo;
import hnu.mapper.UserInfoMapper;
import hnu.mapper.PersonInfoMapper;
import hnu.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/22.
 */
@RestController
@RequestMapping("/pw")
public class PersonInfoController {
    @Autowired
    private PersonInfoService personInfoService;
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("/getonebyid")
    public PersonInfo getOneById(int id){
        return personInfoMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/selectuser")
    public UserInfo selectUser(String memberid){
        return userInfoMapper.selectUser(memberid);
    }

    @RequestMapping("/select")
    public List<PersonInfo> selectByStudnoLike(String studno, String username){
        List list= personInfoService.selectByStudnoAndUsernameLike(studno,username);
        return list;

    }

    @RequestMapping("/checkuser")
    public UserInfo checkUserInfo(String memberid,String password){
        return personInfoService.checkUserInfo(memberid,password);
    }

    @RequestMapping("/updateuserinfo")
    public UserInfo updatePassword(String memberid, String password, String password1, String password2){
        return personInfoService.updatePassword(memberid,password,password1,password2);
    }

    @RequestMapping("/chkpw")
    public PwCheckResult authpw(@RequestParam("pw")String pw,
                                @RequestParam("username")String username,
                                @RequestParam("studno")String studno){
        Integer nCheckResult=0;
        String errMsg=new String("正常");
        Boolean nameHasVal=false;  //姓名是否有值
        Boolean studHasVal=false;  //学号是否有值
        PwCheckResult pcr=new PwCheckResult();
        if((pw.trim().length()==0)||(pw.isEmpty())){
            nCheckResult=14; //密码为空
            errMsg=new String("密码为空");
        }else{
            //学号不为空则根据学号来查询
            //否则看是否根据姓名查询
            //二者均为空则是错
            if(studno.trim().length()>0){
                studHasVal=true;
            }else if(username.trim().length()>0){
                nameHasVal=true;
            }else{
                nCheckResult=15;
                errMsg=new String("学号与姓名均为空，没法查询");
            }
        }
        if(nCheckResult>0){
            pcr.setErrMsg(errMsg+","+pw+","+username+","+studno);
            pcr.setnCheckResult(nCheckResult);
        }else{
            //有密码也有姓名或学号则进行身份校验
            if(studHasVal){
                pcr= personInfoService.checkAuthByStudNo(studno,pw);
            }else if(nameHasVal){
                pcr= personInfoService.checkAuthByName(username,pw);
            }
        }
        return pcr;
    }

    @RequestMapping("/regOne")
    public PersonInfo addOne(@RequestParam("studno")String studno,
                             @RequestParam("username")String username,
                             @RequestParam("pw")String pw){
        PersonInfo personInfo =new PersonInfo();
        //可能要采取正则表达式，进行精确的检测
        if((pw.trim().length()==0)||(pw.isEmpty())){
            pw="123456";   //默认密码
        }
        if((studno.trim().length()==0)||studno.isEmpty()){
            personInfo.setId(-11);
            personInfo.setUsername("学号为空");
        }else if((username.trim().length()==0)||(username.isEmpty())){
            personInfo.setId(-12);
            personInfo.setUsername("姓名为空");
        }else{
            //只要二个不为空，则可以插入了
            personInfo = personInfoService.addOne(studno,username,pw);
        }
        return personInfo;
    }

    @RequestMapping("/modione")
    public PersonInfo modiOneById(@RequestParam("id")Integer id,
                                  @RequestParam("studno")String studno,
                                  @RequestParam("username")String username,
                                  @RequestParam("pw")String pw){
        PersonInfo personInfo =new PersonInfo();
        //可能要采取正则表达式，进行精确的检测
        if((pw.trim().length()==0)||(pw.isEmpty())){
            pw="123456";
        }
        if(id<1){
            personInfo.setId(-13);
            personInfo.setUsername("记录号id为空");
        }
        else if((studno.trim().length()==0)||(studno.isEmpty())){
            personInfo.setId(-11);
            personInfo.setUsername("学号为空");
        }
        else if((username.trim().length()==0)||(username.isEmpty())){
            personInfo.setId(-11);
            personInfo.setUsername("姓名为空");
        }else{
            //只要三个合法，则可以保存了
            personInfo = personInfoService.updateYshpassword(id,username,pw,studno);
        }
        return personInfo;
    }


}


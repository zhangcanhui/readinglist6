package hnu.controller;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.Yshpassword;
import hnu.mapper.UserInfoMapper;
import hnu.mapper.YshpasswordMapper;
import hnu.service.YshpasswordService;
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
public class YshpasswordController {
    @Autowired
    private YshpasswordService yshpasswordService;
    @Autowired
    YshpasswordMapper yshpasswordMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @RequestMapping("/getonebyid")
    public Yshpassword getOneById(int id){
        return yshpasswordMapper.selectByPrimaryKey(id);
    }

    @RequestMapping("/selectuser")
    public UserInfo selectUser(String memberid){
        return userInfoMapper.selectUser(memberid);
    }

    @RequestMapping("/select")
    public List<Yshpassword> selectByStudnoLike(String studno,String username){
        List list=yshpasswordService.selectByStudnoAndUsernameLike(studno,username);
        return list;
        
    }

    @RequestMapping("/checkuser")
    public UserInfo checkUserInfo(String memberid,String password){
        return yshpasswordService.checkUserInfo(memberid,password);
    }

    @RequestMapping("/updateuserinfo")
    public UserInfo updatePassword(String memberid, String password, String password1, String password2){
        return yshpasswordService.updatePassword(memberid,password,password1,password2);
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
                pcr=yshpasswordService.checkAuthByStudNo(studno,pw);
            }else if(nameHasVal){
                pcr=yshpasswordService.checkAuthByName(username,pw);
            }
        }
        return pcr;
    }

    @RequestMapping("/regOne")
    public Yshpassword addOne(@RequestParam("studno")String studno,
                              @RequestParam("username")String username,
                              @RequestParam("pw")String pw){
        Yshpassword yshpassword=new Yshpassword();
        //可能要采取正则表达式，进行精确的检测
        if((pw.trim().length()==0)||(pw.isEmpty())){
            pw="123456";   //默认密码
        }
        if((studno.trim().length()==0)||studno.isEmpty()){
            yshpassword.setId(-11);
            yshpassword.setUsername("学号为空");
        }else if((username.trim().length()==0)||(username.isEmpty())){
            yshpassword.setId(-12);
            yshpassword.setUsername("姓名为空");
        }else{
            //只要二个不为空，则可以插入了
            yshpassword=yshpasswordService.addOne(studno,username,pw);
        }
        return yshpassword;
    }

    @RequestMapping("/modione")
    public Yshpassword modiOneById(@RequestParam("id")Integer id,
                                   @RequestParam("studno")String studno,
                                   @RequestParam("username")String username,
                                   @RequestParam("pw")String pw){
        Yshpassword yshpassword=new Yshpassword();
        //可能要采取正则表达式，进行精确的检测
        if((pw.trim().length()==0)||(pw.isEmpty())){
            pw="123456";
        }
        if(id<1){
            yshpassword.setId(-13);
            yshpassword.setUsername("记录号id为空");
        }
        else if((studno.trim().length()==0)||(studno.isEmpty())){
            yshpassword.setId(-11);
            yshpassword.setUsername("学号为空");
        }
        else if((username.trim().length()==0)||(username.isEmpty())){
            yshpassword.setId(-11);
            yshpassword.setUsername("姓名为空");
        }else{
            //只要三个合法，则可以保存了
            yshpassword=yshpasswordService.updateYshpassword(id,username,pw,studno);
        }
        return yshpassword;
    }
}

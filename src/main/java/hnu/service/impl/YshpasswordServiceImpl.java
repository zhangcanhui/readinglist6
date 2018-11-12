package hnu.service.impl;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.Yshpassword;
import hnu.mapper.UserInfoMapper;
import hnu.mapper.YshpasswordMapper;
import hnu.service.YshpasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Service
public class YshpasswordServiceImpl implements YshpasswordService {
    @Autowired
    YshpasswordMapper yshpasswordMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public Yshpassword getpasswordOne(Integer id) {
        return yshpasswordMapper.selectByPrimaryKey(id);
    }

    @Override
    public Yshpassword selectByStudno(String studno) {
        return yshpasswordMapper.selectByStudno(studno);
    }

    @Override
    public Yshpassword selectByName(String name) {
        return yshpasswordMapper.selectByName(name);
    }

    @Override
    public PwCheckResult checkAuthByStudNo(String studno,String pw) {
        //根据学号查出人员的基本信息，再比较密码是否正确
        Yshpassword yshpassword=yshpasswordMapper.selectByStudno(studno);
        PwCheckResult pwCheckResult=new PwCheckResult();
        if(yshpassword==null){
            //没有这条记录
            pwCheckResult.setnCheckResult(3);//3号错没有这个学号
            pwCheckResult.setErrMsg("没有这个学号");
        }else if(yshpassword.getPw().trim().equals(pw)){
            pwCheckResult.setnCheckResult(1);//身份验证通过
            pwCheckResult.setErrMsg("身份验证通过");
        }else{
            pwCheckResult.setnCheckResult(2);//2号错，密码错误
            pwCheckResult.setErrMsg("该学号存在，但密码错误");
        }
        return pwCheckResult;
    }

    @Override
    public PwCheckResult checkAuthByName(String name,String pw) {
        //根据姓名查出人员的基本信息，再比较密码是否正确
        Yshpassword yshpassword=yshpasswordMapper.selectByName(name);
        PwCheckResult pwCheckResult=new PwCheckResult();
        if (yshpassword==null){
            //没有这条记录
            pwCheckResult.setnCheckResult(4);//4号错没有这个姓名
            pwCheckResult.setErrMsg("没有这个姓名");
        }
        else if (yshpassword.getPw().trim().equals(pw)){
            pwCheckResult.setnCheckResult(1);//身份验证通过
            pwCheckResult.setErrMsg("身份验证通过");
        } else {
            pwCheckResult.setnCheckResult(5);//5号错，密码错误
            pwCheckResult.setErrMsg("该姓名存在，但密码错误");
        }
        return pwCheckResult;
    }

    @Override
    public List<Yshpassword> getAll() {
        return yshpasswordMapper.selectAll();
    }

    @Override
    public Yshpassword addOne(String studno, String username, String pw) {
        //增加一条记录
        //先查询是否有这条记录，根据学号查询
        Yshpassword yshpasswordOne=yshpasswordMapper.selectByStudno(studno);
        int flag=0;
        if(yshpasswordOne==null){
            yshpasswordOne=new Yshpassword();
            yshpasswordOne.setUsername(username);
            yshpasswordOne.setPw(pw);
            yshpasswordOne.setStudno(studno);
            flag=yshpasswordMapper.insertYshpassword(yshpasswordOne);
            if(flag==1){
                //插入成功则返回当前记录，记录号等于1
                yshpasswordOne=yshpasswordMapper.selectByStudno(studno);
            }else{
                yshpasswordOne.setId(-2);
                yshpasswordOne.setUsername("插入不成功!");
            }
        }else{
            yshpasswordOne.setId(-1);
            yshpasswordOne.setUsername("学号已存在");
        }
        return yshpasswordOne;
    }

    @Override
    public List<Yshpassword> selectByStudnoAndUsernameLike(String studno, String username) {
        List<Yshpassword> list=new ArrayList<Yshpassword>();
        if(((studno.trim().length()==0)||(studno.trim()==""))&&((username.trim().length()==0)||(username.trim()==""))){
            list=yshpasswordMapper.selectAll();
        }else{
            list=yshpasswordMapper.selectByStudnoAndUsernameLike(studno,username);
        }
        return list;
    }

    @Override
    public Yshpassword updateYshpassword(Integer id, String username, String pw, String studno) {
        int flag=yshpasswordMapper.updateYshpassword(id,username,pw,studno);
        Yshpassword yshpassword=new Yshpassword();
        if(flag>0){
             yshpassword=yshpasswordMapper.selectByPrimaryKey(id);
        }else{
            yshpassword.setId(-1);
            yshpassword.setUsername("修改不成功！");
        }
        return yshpassword;
    }

    @Override
    public UserInfo checkUserInfo(String memberid, String password) {
        UserInfo userInfo=userInfoMapper.selectUserInfo(memberid,password);
        return userInfo;
    }

    @Override
    public UserInfo updatePassword(String memberid, String password, String password1, String password2) {
        UserInfo userInfo=userInfoMapper.selectUser(memberid);
        if(userInfo!=null){
            if(userInfo.getPassword().equals(password)){  //验证输入密码是否与原密码相同
                if(password1.equals(password2)){  //验证两次输入的密码是否相同
                    userInfo.setPassword(password1);
                    userInfoMapper.updateUserInfo(userInfo);
                    return userInfo;
                }
            }
        }
        return null;
    }

}

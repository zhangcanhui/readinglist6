package hnu.service.impl;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.PersonInfo;
import hnu.mapper.UserInfoMapper;
import hnu.mapper.PersonInfoMapper;
import hnu.service.PersonInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Service
public class PersonInfoServiceImpl implements PersonInfoService {
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Autowired
    UserInfoMapper userInfoMapper;

    @Override
    public PersonInfo getpasswordOne(Integer id) {
        return personInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public PersonInfo selectByStudno(String studno) {
        return personInfoMapper.selectByStudno(studno);
    }

    @Override
    public PersonInfo selectByName(String name) {
        return personInfoMapper.selectByName(name);
    }

    @Override
    public PwCheckResult checkAuthByStudNo(String studno,String pw) {
        //根据学号查出人员的基本信息，再比较密码是否正确
        PersonInfo personInfo = personInfoMapper.selectByStudno(studno);
        PwCheckResult pwCheckResult=new PwCheckResult();
        if(personInfo ==null){
            //没有这条记录
            pwCheckResult.setnCheckResult(3);//3号错没有这个学号
            pwCheckResult.setErrMsg("没有这个学号");
        }else if(personInfo.getPw().trim().equals(pw)){
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
        PersonInfo personInfo = personInfoMapper.selectByName(name);
        PwCheckResult pwCheckResult=new PwCheckResult();
        if (personInfo ==null){
            //没有这条记录
            pwCheckResult.setnCheckResult(4);//4号错没有这个姓名
            pwCheckResult.setErrMsg("没有这个姓名");
        }
        else if (personInfo.getPw().trim().equals(pw)){
            pwCheckResult.setnCheckResult(1);//身份验证通过
            pwCheckResult.setErrMsg("身份验证通过");
        } else {
            pwCheckResult.setnCheckResult(5);//5号错，密码错误
            pwCheckResult.setErrMsg("该姓名存在，但密码错误");
        }
        return pwCheckResult;
    }

    @Override
    public List<PersonInfo> getAll() {
        return personInfoMapper.selectAll();
    }

    @Override
    public PersonInfo addOne(String studno, String username, String pw) {
        //增加一条记录
        //先查询是否有这条记录，根据学号查询
        PersonInfo personInfoOne = personInfoMapper.selectByStudno(studno);
        int flag=0;
        if(personInfoOne ==null){
            personInfoOne =new PersonInfo();
            personInfoOne.setUsername(username);
            personInfoOne.setPw(pw);
            personInfoOne.setStudno(studno);
            flag= personInfoMapper.insertYshpassword(personInfoOne);
            if(flag==1){
                //插入成功则返回当前记录，记录号等于1
                personInfoOne = personInfoMapper.selectByStudno(studno);
            }else{
                personInfoOne.setId(-2);
                personInfoOne.setUsername("插入不成功!");
            }
        }else{
            personInfoOne.setId(-1);
            personInfoOne.setUsername("学号已存在");
        }
        return personInfoOne;
    }

    @Override
    public List<PersonInfo> selectByStudnoAndUsernameLike(String studno, String username) {
        List<PersonInfo> list=new ArrayList<PersonInfo>();
        if(((studno.trim().length()==0)||(studno.trim()==""))&&((username.trim().length()==0)||(username.trim()==""))){
            list= personInfoMapper.selectAll();
        }else{
            list= personInfoMapper.selectByStudnoAndUsernameLike(studno,username);
        }
        return list;
    }

    @Override
    public PersonInfo updateYshpassword(Integer id, String username, String pw, String studno) {
        int flag= personInfoMapper.updateYshpassword(id,username,pw,studno);
        PersonInfo personInfo =new PersonInfo();
        if(flag>0){
             personInfo = personInfoMapper.selectByPrimaryKey(id);
        }else{
            personInfo.setId(-1);
            personInfo.setUsername("修改不成功！");
        }
        return personInfo;
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

package hnu.service;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.PersonInfo;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface PersonInfoService {
    PersonInfo getpasswordOne(Integer id);
    PersonInfo selectByStudno(String studno);
    PersonInfo selectByName(String name);
    PwCheckResult checkAuthByStudNo(String studno,String pw);
    PwCheckResult checkAuthByName(String name,String pw);
    List<PersonInfo> getAll();
    PersonInfo addOne(String studno, String username, String pw);
    List<PersonInfo> selectByStudnoAndUsernameLike(String studno, String username);
    PersonInfo updateYshpassword(Integer id, String username, String pw, String studno);
    UserInfo checkUserInfo(String memberid,String password);
    UserInfo updatePassword(String memberid,String password,String password1,String password2);
}

package hnu.service;

import hnu.entity.PwCheckResult;
import hnu.entity.UserInfo;
import hnu.entity.Yshpassword;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface YshpasswordService {
    Yshpassword getpasswordOne(Integer id);
    Yshpassword selectByStudno(String studno);
    Yshpassword selectByName(String name);
    PwCheckResult checkAuthByStudNo(String studno,String pw);
    PwCheckResult checkAuthByName(String name,String pw);
    List<Yshpassword> getAll();
    Yshpassword addOne(String studno,String username,String pw);
    List<Yshpassword> selectByStudnoAndUsernameLike(String studno,String username);
    Yshpassword updateYshpassword(Integer id,String username,String pw,String studno);
    UserInfo checkUserInfo(String memberid,String password);
    UserInfo updatePassword(String memberid,String password,String password1,String password2);
}

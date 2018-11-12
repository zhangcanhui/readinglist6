package hnu.mapper;

import hnu.entity.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public interface UserInfoMapper {
    @Select("select * from userinfo where memberid=#{memberid} and password=#{password}")
    UserInfo selectUserInfo(@Param("memberid")String memberid,@Param("password")String password);

    @Select("select * from userinfo where memberid=#{memberid}")
    UserInfo selectUser(String memberid);

    @Update("update userinfo set password=#{password} where memberid=#{memberid}")
    void updateUserInfo(UserInfo userInfo);
}

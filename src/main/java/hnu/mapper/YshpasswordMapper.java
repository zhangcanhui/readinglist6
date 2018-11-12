package hnu.mapper;

import hnu.entity.Yshpassword;
import hnu.mapper.provider.YshpasswordProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface YshpasswordMapper {
    @Delete("delete from personinfo where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Select("select * from personinfo where id=#{id}")
    Yshpassword selectByPrimaryKey(Integer id);

    @Select("select * from personinfo where studno=#{studno}")
    Yshpassword selectByStudno(String studno);

    @Select("select * from personinfo where username=#{username}")
    Yshpassword selectByName(String name);

    @Select("select * from personinfo")
    List<Yshpassword> selectAll();

    @Select("select * from personinfo where studno like CONCAT(CONCAT('%', #{studno}),'%')" +
            "and username like concat(concat('%',#{username}),'%')")
    List<Yshpassword> selectByStudnoAndUsernameLike(@Param("studno") String studno,@Param("username") String username);

    @Insert("insert into personinfo(username,pw,studno) values(#{username},#{pw},#{studno})")
    int insertYshpassword(Yshpassword yshpassword);

    @UpdateProvider(type = YshpasswordProvider.class,method = "updateYshpassword")
    int updateYshpassword(Integer id,String username,String pw,String studno);
}

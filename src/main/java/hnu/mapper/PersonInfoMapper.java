package hnu.mapper;

import hnu.entity.PersonInfo;
import hnu.mapper.provider.PersonInfoProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface PersonInfoMapper {
    @Delete("delete from personinfo where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Select("select * from personinfo where id=#{id}")
    PersonInfo selectByPrimaryKey(Integer id);

    @Select("select * from personinfo where studno=#{studno}")
    PersonInfo selectByStudno(String studno);

    @Select("select * from personinfo where username=#{username}")
    PersonInfo selectByName(String name);

    @Select("select * from personinfo")
    List<PersonInfo> selectAll();

    @Select("select * from personinfo where studno like CONCAT(CONCAT('%', #{studno}),'%')" +
            "and username like concat(concat('%',#{username}),'%')")
    List<PersonInfo> selectByStudnoAndUsernameLike(@Param("studno") String studno, @Param("username") String username);

    @Insert("insert into personinfo(username,pw,studno) values(#{username},#{pw},#{studno})")
    int insertYshpassword(PersonInfo personInfo);

    @UpdateProvider(type = PersonInfoProvider.class,method = "updateYshpassword")
    int updateYshpassword(Integer id,String username,String pw,String studno);
}

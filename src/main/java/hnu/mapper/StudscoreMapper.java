package hnu.mapper;

import hnu.entity.Studscore;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Mapper
public interface StudscoreMapper {
    @Select("select * from studscore where id=#{id}")
    Studscore selectByPrimaryKey(Integer id);

    @Delete("delete from studscore where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Select("select * from studscore")
    List<Studscore> selectAll();
}

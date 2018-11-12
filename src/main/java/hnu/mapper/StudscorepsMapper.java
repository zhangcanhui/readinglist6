package hnu.mapper;

import hnu.entity.Studscoreps;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Mapper
public interface StudscorepsMapper {
    @Delete("delete from studscoreps where id=#{id}")
    int deleteByPrimaryKey(Integer id);

    @Select("select * from studscoreps where id=#{id}")
    Studscoreps selectByPrimaryKey(Integer id);

    @Select("select * from studscoreps")
    List<Studscoreps> selectAll();
}

package hnu.service.impl;


import hnu.entity.Studscoreps;
import hnu.mapper.StudscorepsMapper;
import hnu.service.StudscorepsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Service
public class StudscorepsServiceImpl implements StudscorepsService {
    @Autowired
    private StudscorepsMapper studscorepsMapper;

    @Override
    public Studscoreps getStudscorepsOne(Integer id) {
        return studscorepsMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Studscoreps> getStudscorepsAll() {
        return studscorepsMapper.selectAll();
    }
}

package hnu.service.impl;

import hnu.entity.Studscore;
import hnu.mapper.StudscoreMapper;
import hnu.service.StudscoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
@Service
public class StudscoreServiceImpl implements StudscoreService{
    @Autowired
    private StudscoreMapper studscoreMapper;

    @Override
    public Studscore getStudscoreOne(Integer id) {
        return studscoreMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Studscore> getStudscoreAll() {
        return studscoreMapper.selectAll();
    }
}

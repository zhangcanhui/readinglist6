package hnu.service;

import hnu.entity.Studscoreps;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface StudscorepsService {
    Studscoreps getStudscorepsOne(Integer id);
    List<Studscoreps> getStudscorepsAll();
}

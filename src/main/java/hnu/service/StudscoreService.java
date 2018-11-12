package hnu.service;

import hnu.entity.Studscore;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public interface StudscoreService {
    Studscore getStudscoreOne(Integer id);
    List<Studscore> getStudscoreAll();
}

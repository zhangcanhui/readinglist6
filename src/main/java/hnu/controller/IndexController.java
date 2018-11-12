package hnu.controller;

import hnu.entity.Studscore;
import hnu.entity.Studscoreps;
import hnu.mapper.StudscoreMapper;
import hnu.mapper.StudscorepsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/22.
 */
@RestController
public class IndexController {
    @Autowired
    StudscoreMapper studscoreMapper;
    @Autowired
    StudscorepsMapper studscorepsMapper;

    @RequestMapping("/")
    public String home(){
        return "hello!";
    }

    @ResponseBody
    @RequestMapping(value = "/studscore/{id}",produces = {"application/json;charset=UTF-8"})
    public Studscore getStudScoreOne(@PathVariable("id")Integer id){
        return studscoreMapper.selectByPrimaryKey(id);
    }

    @RequestMapping(value = "/studscoreall",produces = {"application/json;charset=UTF-8"})
    public List<Studscore> getStudScoreAll(){
        return studscoreMapper.selectAll();
    }

    @RequestMapping(value = "/studscorepsall", produces = {"application/json;charset=UTF-8"})
    public List<Studscoreps> getScoreAll(){
        return  studscorepsMapper.selectAll();
    }
}

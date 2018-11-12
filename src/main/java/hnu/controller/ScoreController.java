package hnu.controller;

import hnu.entity.Studscore;
import hnu.service.StudscoreService;
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
@RequestMapping(value = "/score")
public class ScoreController {
    @Autowired
    private StudscoreService studscoreService;

    @ResponseBody
    @RequestMapping("/one/{id}")
    public Studscore getOne(@PathVariable("id")Integer id){
        return studscoreService.getStudscoreOne(id);
    }

    @RequestMapping("/all")
    public List<Studscore> getAll(){
        return studscoreService.getStudscoreAll();
    }

}

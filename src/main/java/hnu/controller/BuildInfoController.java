package hnu.controller;

import hnu.entity.BuildInfo;
import hnu.service.BuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
@RestController
@RequestMapping("/buildinfo")
public class BuildInfoController {
    @Autowired
    BuildInfoService buildInfoService;

    @RequestMapping("/selectbuildinfo")
    public List<BuildInfo> selectBuildInfo(Integer buildno, Integer buildcount, Integer familnum, Integer floornum, String buildname){
        List list=buildInfoService.selectBuildInfo(buildno,buildcount,familnum,floornum,buildname);
        return list;
    }

}

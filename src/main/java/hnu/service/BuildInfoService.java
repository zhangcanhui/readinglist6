package hnu.service;

import hnu.entity.BuildInfo;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public interface BuildInfoService {
    List<BuildInfo> selectBuildInfo(Integer buildno, Integer buildcount, Integer familnum, Integer floornum, String buildname);

    Integer insertBuildInfo(String buildname,Integer floornum,Integer familynumeachfloor);
}

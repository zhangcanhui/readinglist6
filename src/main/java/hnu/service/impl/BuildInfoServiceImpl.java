package hnu.service.impl;

import hnu.entity.BuildInfo;
import hnu.mapper.BuildInfoMapper;
import hnu.service.BuildInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
@Service
public class BuildInfoServiceImpl implements BuildInfoService{
    @Autowired
    BuildInfoMapper buildInfoMapper;

    public List<BuildInfo> selectBuildInfo(Integer buildno, Integer buildcount, Integer familnum, Integer floornum, String buildname){
        List list=buildInfoMapper.selectBuildInfo(buildno,buildcount,familnum,floornum,buildname);
        return list;
    }

    public Integer insertBuildInfo(String buildname,Integer floornum,Integer familynumeachfloor){
        BuildInfo buildInfo=new BuildInfo();
        buildInfo.setBuildname(buildname);
        buildInfo.setFloornum(floornum);
        buildInfo.setFamilynumeachfloor(familynumeachfloor);
        Integer flag=buildInfoMapper.insertBuildInfo(buildInfo);
        return flag;
    }
}

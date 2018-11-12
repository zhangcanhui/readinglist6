package hnu.mapper.provider;

import hnu.entity.BuildInfo;
import org.springframework.util.StringUtils;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public class BuildInfoProvider {
    public String selectBuildInfo(Integer buildno,Integer buildcount,Integer familynum,Integer floornum,String buildname){
        StringBuffer sql=new StringBuffer("select * from buildinfo where 1=1");
        if (!StringUtils.isEmpty(buildno)) {
            sql.append(" and buildno like'%" + buildno + "%'");
        }
        if(!StringUtils.isEmpty(buildcount)){
            sql.append(" and buildcount like'%" + buildcount + "%'");
        }
        if(!StringUtils.isEmpty(familynum)){
            sql.append(" and familynum like'%" + familynum + "%'");
        }
        if(!StringUtils.isEmpty(floornum)){
            sql.append(" and floornum like'%" + floornum + "%'");
        }
        if(!StringUtils.isEmpty(buildname)){
            sql.append(" and buildname like'%" + buildname + "%'");
        }
        return sql.toString();
    }
}

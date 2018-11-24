package hnu.mapper.provider;

import org.springframework.util.StringUtils;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public class PersonInfoProvider {
    public String updateYshpassword(Integer id,String username,String pw,String studno){
        StringBuffer sql=new StringBuffer("update personinfo set");
        if (!StringUtils.isEmpty(username)) {
            sql.append(" username='" + username + "'");
        }
        if(!StringUtils.isEmpty(pw)){
            sql.append(", pw='" + pw + "'");
        }
        if(!StringUtils.isEmpty(studno)){
            sql.append(", studno='" + studno + "'");
        }
        sql.append("where id='" + id + "'");
        return sql.toString();
    }
}

package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public class PersonInfo {
    private Integer id;
    private String username;
    private String pw;
    private String md5;
    private String studno;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getStudno() {
        return studno;
    }

    public void setStudno(String studno) {
        this.studno = studno;
    }
}

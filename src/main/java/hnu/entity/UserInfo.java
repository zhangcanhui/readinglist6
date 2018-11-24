package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public class UserInfo {
    private int id;
    private String memberid;
    private String password;
    private String location;
    private String longandlati;
    private Byte status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemberid() {
        return memberid;
    }

    public void setMemberid(String memberid) {
        this.memberid = memberid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLongandlati() {
        return longandlati;
    }

    public void setLongandlati(String longandlati) {
        this.longandlati = longandlati;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}

package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/23.
 */
public class BuildInfo {   //楼栋信息实体
    private int id;
    private int buildno;  //楼栋编号
    private String buildname;  //楼栋名称
    private int floornum;   //该楼栋层数
    private int familynum;   //户数
    private int familynumeachfloor;   //每层住户数
    private byte buildtype;    //楼栋类型
    private int buildcount;   //单元数
    private int mennum;    //男人数量
    private int womennum;   //女人数量
    private int peoplenum;   //人口数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBuildno() {
        return buildno;
    }

    public void setBuildno(int buildno) {
        this.buildno = buildno;
    }

    public String getBuildname() {
        return buildname;
    }

    public void setBuildname(String buildname) {
        this.buildname = buildname;
    }

    public int getFloornum() {
        return floornum;
    }

    public void setFloornum(int floornum) {
        this.floornum = floornum;
    }

    public int getFamilynum() {
        return familynum;
    }

    public void setFamilynum(int familynum) {
        this.familynum = familynum;
    }

    public int getFamilynumeachfloor() {
        return familynumeachfloor;
    }

    public void setFamilynumeachfloor(int familynumeachfloor) {
        this.familynumeachfloor = familynumeachfloor;
    }

    public byte getBuildtype() {
        return buildtype;
    }

    public void setBuildtype(byte buildtype) {
        this.buildtype = buildtype;
    }

    public int getBuildcount() {
        return buildcount;
    }

    public void setBuildcount(int buildcount) {
        this.buildcount = buildcount;
    }

    public int getMennum() {
        return mennum;
    }

    public void setMennum(int mennum) {
        this.mennum = mennum;
    }

    public int getWomennum() {
        return womennum;
    }

    public void setWomennum(int womennum) {
        this.womennum = womennum;
    }

    public int getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(int peoplenum) {
        this.peoplenum = peoplenum;
    }
}

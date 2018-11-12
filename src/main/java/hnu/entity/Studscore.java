package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public class Studscore {
    private Integer id;
    private String studno;
    private String studname;
    private String coursename;
    private Double ps1;
    private Double ps2;
    private Double examend;
    private Double totalscore;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudno() {
        return studno;
    }

    public void setStudno(String studno) {
        this.studno = studno;
    }

    public String getStudname() {
        return studname;
    }

    public void setStudname(String studname) {
        this.studname = studname;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public Double getPs1() {
        return ps1;
    }

    public void setPs1(Double ps1) {
        this.ps1 = ps1;
    }

    public Double getPs2() {
        return ps2;
    }

    public void setPs2(Double ps2) {
        this.ps2 = ps2;
    }

    public Double getExamend() {
        return examend;
    }

    public void setExamend(Double examend) {
        this.examend = examend;
    }

    public Double getTotalscore() {
        return totalscore;
    }

    public void setTotalscore(Double totalscore) {
        this.totalscore = totalscore;
    }
}

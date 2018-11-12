package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public class Studscoreps {
    private Integer id;
    private String studno;
    private String kc;
    private Double score;
    private Integer studid;

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

    public String getKc() {
        return kc;
    }

    public void setKc(String kc) {
        this.kc = kc;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Integer getStudid() {
        return studid;
    }

    public void setStudid(Integer studid) {
        this.studid = studid;
    }
}

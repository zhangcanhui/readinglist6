package hnu.entity;

/**
 * Created by zhangcanhui on 2018/5/21.
 */
public class PwCheckResult {
    private Integer nCheckResult;
    private String errMsg;

    public Integer getnCheckResult() {
        return nCheckResult;
    }

    public void setnCheckResult(Integer nCheckResult) {
        this.nCheckResult = nCheckResult;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }
}

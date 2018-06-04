package site.it4u.domain;

import site.it4u.enums.HttpEnum;

public class RetEntity {

    private int status;

    private String msg;

    private Object result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public RetEntity() {
        this.status = HttpEnum.HTTP_OK.getCode();
        this.msg = "suc";
    }
}

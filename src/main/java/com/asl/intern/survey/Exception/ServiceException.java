package com.asl.intern.survey.Exception;

public class ServiceException extends Exception {

    private static final long serialVersionUID = 1L;
    private String code;
    private String msg;
    private Boolean data;

    public ServiceException(String code, String msg) {
        this.setCode(code);
        this.setMsg(msg);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}

package com.asl.intern.survey.common;

public enum ResultCode {
    ADD_SUCCESS("1000","新增成功！"),
    ADD_FAIL("1001","新增失败！"),
    MODIFIED_SUCCESS("1100","修改成功！"),
    MODIFIED_FAIL("1101","修改失败！"),
    DELETED_SUCCESS("1200","删除成功！"),
    DELETED_FAIL("1201","删除失败！"),
    FIND_SUCESS("1300","查询成功！"),
    FIND_FAIL("1301","查询失败！");

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}

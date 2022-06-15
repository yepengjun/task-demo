package com.schedule.demo.enums;

public enum CommonResCode implements ResultCode {

    OK(true,10001, "成功"),
    ERROR(false,10002, "失败"),
    NO_HANDLER_FOUND(false, 10003, "找不到执行的路径操作"),
    BIND_EXCEPTION_ERROR(false, 10004, "请求参数错误"),
    UNKNOWN_ERROR(false, 10006, "未知错误"),
    NOT_LOGGED_IN(false, 10007, "未登录认证"),
    CREDENTIALS_DESTROY(false, 10008, "凭证被损坏"),
    LOGIN_OVERDUE(false, 10009, "登录过期"),
    PARAMETER_VALIDATION_ERROR(false,11000, "请求参数校验失败"),
    SIGN_STR_ERROR(false,12000, "签名异常"),
    ;

    boolean success;

    int code;

    String message;

    CommonResCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }

    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

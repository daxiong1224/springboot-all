package com.hx.exception.handle;

/**
 * 年龄的自定义异常
 */
public class AgeException extends RuntimeException{
    private String code;
    private String msg;
    
    public AgeException() {
        super();
    }

    public AgeException(String code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public AgeException(String message) {
        super(message);
        this.msg = message;
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

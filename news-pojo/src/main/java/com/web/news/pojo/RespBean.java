package com.web.news.pojo;

// 消息响应类
public class RespBean {
    // 自定义响应码， 200正常， 500错误
    private Integer code;
    // 错误信息
    private String message;
    // 返回业务数据
    private Object data;

    public static RespBean ok(String message) {
        return new RespBean(200,message);
    }

    public static RespBean ok(String message, Object data) {
        return new RespBean(200, message, data);
    }

    public static RespBean err(String message) {
        return new RespBean(500, message);
    }

    public static RespBean err(String message, Object data) {
        return new RespBean(500, message, data);
    }

    private RespBean(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private RespBean(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

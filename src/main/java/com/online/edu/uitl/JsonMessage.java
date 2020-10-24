package com.gjf.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiao on 2018/10/27.
 * 客户端状态码响应类
 */
public class JsonMessage {
    private int code;//状态码
    private String msg;//响应信息
    private Map<String, Object> info = new HashMap();//返回内容

    public static JsonMessage success() {
        return new JsonMessage(100, "处理成功！");
    }

    public static JsonMessage fail() {
        return new JsonMessage(200, "处理失败！");
    }

    public static JsonMessage error(String msg) {
        return new JsonMessage(200, msg);
    }

    public static JsonMessage exception() {
        return new JsonMessage(300, "处理异常！");
    }

    public static JsonMessage unauthorized() {
        return new JsonMessage(201, "未授权！");
    }

    public static JsonMessage unLogin() {
        return new JsonMessage(202, "未登录！");
    }

    public JsonMessage add(String key, Object o) {
        this.info.put(key, o);
        return this;
    }

    public JsonMessage(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonMessage() {
    }

    public JsonMessage(int code, String msg, Map<String, Object> info) {
        this.code = code;
        this.msg = msg;
        this.info = info;
    }

    public JsonMessage(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getInfo() {
        return info;
    }

    public void setInfo(Map<String, Object> info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", info=" + info +
                '}';
    }
}

package com.coco.ssa.model;

import java.io.Serializable;

/**
 * 数据请求基础类
 * Created by Hoyn on 17/3/24.
 */

public class BaseModel<T> implements Serializable{
    //状态码
    public int code;
    //服务器消息
    public String msg;
    public boolean hasmore;
    //数据
    public T data;

    public static int SUCCESS = 1;
    public static int SIGN_OUT = 100;//token验证失败
    public static int SHOWTOAST = 3;//显示Toast

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return SUCCESS==code;
    }

    public boolean isTokenInvalid() {
        return SIGN_OUT==code;
    }

    public boolean isShowToast() {
        return SHOWTOAST==code;
    }

    public boolean hasMore() {
        return hasmore;
    }
}

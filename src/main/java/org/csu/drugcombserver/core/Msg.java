package org.csu.drugcombserver.core;

import org.csu.drugcombserver.entity.Code;

public class Msg<T> {
    private Integer code;
    private T data;
    private String msg;

    public Msg() {
    }

    public Msg(T data) {
        this.code = Code.SUCCESS;
        this.msg = "success";
        this.data = data;
    }

    public Msg(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

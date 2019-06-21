package com.zzl.common.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc: 统一返回结果类
 * @author: john（coder_john@163.com）
 * @date: 2019/6/4
 */
@Data
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -2792556188993845048L;

    /** 返回码 */
    private Integer code;

    /** 返回信息 */
    private String message;

    /** 返回数据 */
    private T data;

    public Result() {
    }

    public Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public Result(ResultCode resultCode, T data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }
}

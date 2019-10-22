package com.zzl.common.result;

import lombok.Data;

import java.io.Serializable;

/**
 * @desc: 统一返回结果类
 * @author: john（coder_john@163.com）
 * @date: 2019/6/4
 */
@Data
public class Result implements Serializable {

    private static final long serialVersionUID = 2472123399388185767L;

    /** 返回码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 返回数据 */
    private Object data;

    public Result() {
    }

    private Result(Object data) {
        this.code = ResultStatus.SUCCESS.getCode();
        this.message = ResultStatus.SUCCESS.getMessage();
        this.data = data;
    }

    private Result(ResultCode resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    private Result(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    private Result(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private Result(ResultCode resultCode, Object data) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.data = data;
    }

    public static Result success(){
        return new Result(ResultStatus.SUCCESS);
    }

    public static Result success(Object data){
        return new Result(ResultStatus.SUCCESS, data);
    }

    public static Result success(ResultCode resultCode, Object data){
        return new Result(resultCode, data);
    }

    public static Result success(Integer code, String message, Object data){
        return new Result(code, message, data);
    }

    public static Result fail(){
        return new Result(ResultStatus.EXCEPTION_ERROR);
    }

    public static Result fail(Integer code, String message){
        return new Result(code, message);
    }

    public static Result fail(ResultCode resultCode){
        return new Result(resultCode.getCode(), resultCode.getMessage());
    }
}

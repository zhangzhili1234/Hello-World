package com.zzl.common.response;

/**
 * @desc: Rest返回信息整理工具类
 * @author: john（coder_john@163.com）
 * @date: 2019/6/4
 */
public class BaseRest<T> {

    protected Result success(){
        return this.success(ResultStatus.SUCCESS, null);
    }

    protected Result success(ResultCode resultCode){
        return new Result(resultCode.getCode(), resultCode.getMessage());
    }

    protected Result success(T data){
        return this.success(ResultStatus.SUCCESS, data);
    }

    protected Result success(ResultCode resultCode, T data) {
        return new Result<T>(resultCode.getCode(), resultCode.getMessage(), data);
    }

    protected Result fail(){
        return this.fail(ResultStatus.EXCEPTION_ERROR);
    }

    protected Result fail(int code, String msg){
        return new Result(code, msg);
    }

    protected Result fail(ResultCode resultCode){
        return new Result(resultCode.getCode(), resultCode.getMessage());
    }
}

package com.zzl.common.result;

/**
 * @desc: 自定义异常：运行时主动抛异常
 * @author: john（zhangzhili@163.com）
 * @date: 2019/6/14
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = -4151320117104093319L;

    private Integer code = 400;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.code = resultCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    @Override
    public String toString() {
        return "BizException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                "}";
    }
}

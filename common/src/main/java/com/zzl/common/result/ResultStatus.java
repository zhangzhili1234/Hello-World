package com.zzl.common.result;

/**
 * @desc: 常用返回状态枚举
 * @author: john（coder_john@163.com）
 * @date: 2019/6/4
 */
public enum  ResultStatus implements ResultCode {

    SUCCESS(200, "请求成功"),

    EXCEPTION_ERROR(500, "系统异常,请稍后再试"),

    TOKEN_FAIL(401,"请登录"),

    TOKEN_INVALID(401, "鉴权无效，请重新登陆"),

    ACCOUNT_LOG_ELSEWHERE(401, "账号已在其它设备登陆"),

    ILLEGAL_REQUEST(403, "非法请求"),

    INTERFACE_DISABLE(403, "接口已禁用"),

    CODE_ERROR(405, "验证码错误或失效"),

    SMS_TOO_MANY(405, "短信发送请求频繁"),

    PARAMS_ERROR(407, "传入的参数错误，或者缺失"),

    GOODS_ID_INVALD(407, "商品ID无效"),

    ORDER_SN_INVALID(407, "订单编号无效"),

    MEMBER_AUTH(409, "用户权限不通过"),

    OPERATE_FAIL(411, "无效的操作");

    private int code;

    private String message;

    ResultStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

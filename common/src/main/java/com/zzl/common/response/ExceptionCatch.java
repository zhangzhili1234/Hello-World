package com.zzl.common.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @desc: 全局异常捕捉处理
 * @author: john（coder_john@163.com）
 * @date: 2019/6/10
 */
@Slf4j
@ControllerAdvice
public class ExceptionCatch extends BaseRest {

    /**
     * 全局异常捕捉处理
     * @param e
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception e) {

        // 参数校验不通过报异常
        if (e instanceof MethodArgumentNotValidException) {
            log.error("MethodArgumentNotValidException happened...", e);
            BindingResult result = ((MethodArgumentNotValidException) e).getBindingResult();
            if (result.hasFieldErrors()) {
                StringBuilder sb = new StringBuilder();
                sb.append("Error form is ").append(result.getObjectName()).append(", error fields include:");
                List<FieldError> errors = result.getFieldErrors();
                for (FieldError fieldError : errors) {
                    sb.append(fieldError.getDefaultMessage()).append("; ");
                }
                log.warn(sb.toString());
                return new Result(407, errors.get(0).getDefaultMessage());
            }
            return this.fail();
        }

        // 运行时主动抛异常
        if (e instanceof BizException) {
            BizException ex = (BizException) e;
            log.error("BizException happened..." + ex.toString());
            return new Result(ex.getCode(), ex.getMessage());
        }

        // 其他异常
        log.error("Exception happened...", e);
        return this.fail();
    }
}

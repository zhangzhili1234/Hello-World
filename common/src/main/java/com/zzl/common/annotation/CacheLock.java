package com.zzl.common.annotation;

import java.lang.annotation.*;

/**
 * @desc: 分布式锁注解
 * @author: john（coder_john@163.com）
 * @date: 2019/6/18
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CacheLock {

    // redis锁 key的前缀
    String lockedPrefix() default "";

    //key在redis里存在的时间，默认30S
    long expireTime() default 30L;
}
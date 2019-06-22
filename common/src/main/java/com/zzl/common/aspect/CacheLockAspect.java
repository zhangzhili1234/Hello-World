package com.zzl.common.aspect;

import com.zzl.common.annotation.CacheLock;
import com.zzl.common.redis.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * @desc: 切面实现redis分布式锁调用
 * @author: john（coder_john@163.com）
 * @date: 2019/6/18
 */
@Aspect
@Slf4j
@Component
public class CacheLockAspect {

    private static final String LOCK_VALUE = "locked";

    @Resource
    private RedisUtil redisUtil;

    @Around("execution(* *.*(..)) && @annotation(com.zzl.common.annotation.CacheLock)")
    public void cacheLockPoint(ProceedingJoinPoint point) {
        Method cacheMethod = null;
        for (Method method : point.getTarget().getClass().getMethods()) {
            if (null != method.getAnnotation(CacheLock.class)) {
                cacheMethod = method;
                break;
            }
        }
        Assert.notNull(cacheMethod, "cacheMethod is null!!!");
        try {
            String lockKey = cacheMethod.getAnnotation(CacheLock.class).lockedPrefix();
            long timeOut = cacheMethod.getAnnotation(CacheLock.class).expireTime();
            Assert.hasText(lockKey, "cacheMethod lockedPrefix is null!!!");
            if (redisUtil.setnx(lockKey, LOCK_VALUE, timeOut)) {
                log.info("method:{}获取锁:{},开始运行！", cacheMethod, lockKey);
                point.proceed();
                return;
            }
            log.info("method:{}未获取锁:{},运行失败！", cacheMethod, lockKey);
        } catch (Throwable e) {
            log.error("method:{},运行错误！", cacheMethod, e);
        }
    }
}

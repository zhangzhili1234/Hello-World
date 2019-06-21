package com.zzl.common.redis;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @desc: Redis工具类
 * @author: john（coder_john@163.com）
 * @date: 2019/6/4
 */
public class RedisUtil {

    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtil(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * redis中是否存在该key
     * @param key
     * @return
     */
    public Boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 制定key的过期时间
     * @param key
     * @param expireTime
     */
    public Boolean expire(String key, Long expireTime) {
        return redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    public Boolean delete(String key) {
        return redisTemplate.delete(key);
    }

    /**
     * 保存键值对，并设定有效时间
     * @param key
     * @param value
     * @param expireTime
     */
    public void set(String key, String value, Long expireTime) {
        redisTemplate.opsForValue().set(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 根据key查询value
     * @param key
     * @return
     */
    public Object get(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 根据key获取redis锁
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public Boolean setnx(String key, String value, Long expireTime) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, expireTime, TimeUnit.SECONDS);
    }

    /**
     * 向redis的hash链表中加入数据
     * @param key
     * @param data
     */
    public void setHash(String key, Map<String, Object> data){
        redisTemplate.opsForHash().putAll(key, data);
    }

    /**
     * 根据key和hashKey获取对象
     * @param key
     * @param hashKey
     * @return
     */
    public Object getHashValue(String key, String hashKey){
        return redisTemplate.opsForHash().get(key, hashKey);
    }


}

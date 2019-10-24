package com.zzl.chat.retry;

import org.joda.time.DateTime;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author john(coder_john@163.com)
 * @desc retry测试类
 * @date 2019-07-22
 */
@RestController
public class RetryTest {

    @GetMapping("/retry")
    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 5000, multiplier = 2))
    public void print() throws Exception {
        System.out.println(new DateTime().toString("yyyy-MM-dd HH:mm:ss"));
        throw new Exception("感觉恋爱了。。。");
    }
}

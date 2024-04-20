package com.wd.demo.retryTest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TestServiceImpl implements TestService {


    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 1000, multiplier = 1))
    public void testRetry() {
        log.info("重试测试");
        throw new RuntimeException();
    }

    @Recover
    public void recallMethod(Exception e){
        log.info("执行回调方法");
        // 可以抛出异常
    }
}

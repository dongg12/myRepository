package com.wd.redis.controller;

import com.wd.redis.entity.User;
import com.wd.redis.utils.RedisClusterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

@RestController
@Slf4j
public class RedisDemoController {
//    @Autowired
//    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/redisDemo")
    public void redisDemoController(){
        // 测试线程安全，程序结束查看redis中count的值是否为1000
//        ExecutorService executorService = Executors.newFixedThreadPool(1000);
//        IntStream.range(0, 1000).forEach(i -> executorService.execute(() -> stringRedisTemplate.opsForValue().increment("count", 1)));

//        stringRedisTemplate.opsForValue().set("k1", "v1");
//        String k1 = stringRedisTemplate.opsForValue().get("k1");
//        log.debug("【k1】= {}", k1);

//        // 以下演示整合，具体Redis命令可以参考官方文档
//        String key = "xkcoding:user:1";
//        redisCacheTemplate.opsForValue().set(key, new User(1L, "user1"));
//        // 对应 String（字符串）
//        User user = (User) redisCacheTemplate.opsForValue().get(key);
//        log.debug("【user】= {}", user);
//        String k1 = stringRedisTemplate.opsForValue().get("wangdong");
//        log.info("get from redis {}",k1);
//
//        stringRedisTemplate.opsForValue().set("wangdong1", "wd1");

        RedisClusterUtil util = new RedisClusterUtil();
        util.set("wangdong2", "wd2");
    }
}

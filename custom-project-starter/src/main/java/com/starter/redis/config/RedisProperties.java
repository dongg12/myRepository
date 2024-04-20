package com.starter.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "my.redis")
public class RedisProperties {
    private String host;
    private String password;
}

package com.starter.redis.config;

import com.starter.redis.mark.EnableMark;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.Jedis;


/**
 * import 会把标记类导入到spring容器中
 * 当我们加上enable注解会自动导入标记类，如果不加那就容器中没有这个bean
 * 没有这个bean的话，这个配置类中设置的两个bean对象都不会生成，也就是redis不能使用
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
@ConditionalOnBean(EnableMark.class)
public class RedisConfiguration {

    @Bean
    public Jedis buildJedis(RedisProperties redisProperties){
        Jedis jedis = new Jedis(redisProperties.getHost(), 6379);
        jedis.auth(redisProperties.getPassword());
        return jedis;
    }

    @Bean
    public RedisTemplate redisTemplate(Jedis jedis){
        return new RedisTemplate(jedis);
    }
}

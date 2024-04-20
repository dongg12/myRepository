package com.starter.redis.config;

import redis.clients.jedis.Jedis;

public class RedisTemplate {
    private Jedis jedis;

    public RedisTemplate(Jedis jedis){
        this.jedis = jedis;
    }

    public void setString(String key,String value){
        jedis.set(key, value);
    }

    public String getByKey(String key){
        return jedis.get(key);
    }
}

package com.starter.redis.annotation;


import com.starter.redis.mark.EnableMark;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({EnableMark.class})
public @interface EnableRedisService {
}

package com.wd.demo.printParam;


import cn.hutool.core.io.IoUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
@Aspect
@Slf4j
public class PrintLogAspect {

    @Pointcut("execution(* com.wd.demo.controller.*.*(..))")
    public void methodCut(){
    }

    @Around("methodCut()")
    public Object logControllerMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        assert requestAttributes != null;
        HttpServletRequest request = requestAttributes.getRequest();
        // 获取所有请求头名称
        Enumeration<String> headerNames = request.getHeaderNames();
        Map<String, Object> headerMap = new HashMap<>();
        while (headerNames.hasMoreElements()){
            String headName = headerNames.nextElement();
            String value = request.getHeader(headName);
            headerMap.put(headName, value);
        }
        String requestString = JSON.toJSONString(joinPoint.getArgs());
        PrintLogParamDto paramDto = PrintLogParamDto.builder().headerMap(headerMap).url(request.getRequestURI()).request(requestString).build();
        log.info("入参打印：" + paramDto.toString());
        Object result = joinPoint.proceed();
        log.info("出参打印" + JSON.toJSONString(result));
        return result;
    }
}

package com.wd.demo.controller;

import com.wd.demo.entity.User;
import com.wd.demo.retryTest.TestService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SpringbootDemoController {
    @Autowired
    private TestService testService;

//    @Desensitization
    @PostMapping("/sensitiveTest")
    public User sensitiveTestController(@RequestBody User user){
        return user;
    }

    @PostMapping("/validatedTest")
    public User validatedTest(@RequestBody @Validated User user){
        return user;
    }

    @PostMapping("/springTryTest")
    public void springTryTest(){
        testService.testRetry();
        log.info("trace id is {}",MDC.get("traceId"));
    }

    public static void main(String[] args) {

    }
}

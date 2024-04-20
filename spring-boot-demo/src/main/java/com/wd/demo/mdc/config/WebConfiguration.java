package com.wd.demo.mdc.config;

import com.wd.demo.mdc.TraceFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class WebConfiguration {

    @Bean
    public FilterRegistrationBean<TraceFilter> filterRegistrationBean(){
        FilterRegistrationBean<TraceFilter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new TraceFilter());
        bean.addUrlPatterns("/*");
        return bean;
    }
}

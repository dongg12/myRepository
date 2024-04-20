package com.wd.demo.mdc;

import com.wd.demo.mdc.util.TraceIdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns="/*")
public class TraceFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("init trace filter ...");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {

            HttpServletRequest serverRequest = (HttpServletRequest) request;
            String traceId = serverRequest.getHeader("traceId");
            if (StringUtils.hasLength(traceId)) {
                TraceIdUtil.generateTraceId(traceId);
            } else {
                TraceIdUtil.generateTraceId();
            }
            chain.doFilter(request,response);
        } catch (Exception e) {
            log.error("trace id filter error",e);
        } finally {
            TraceIdUtil.removeTraceId();
        }
    }
}

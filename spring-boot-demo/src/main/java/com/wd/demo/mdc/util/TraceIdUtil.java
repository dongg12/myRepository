package com.wd.demo.mdc.util;

import cn.hutool.core.util.IdUtil;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

public class TraceIdUtil {
    public static String generateTraceId(){
        String traceId = IdUtil.fastSimpleUUID().toLowerCase();
        MDC.put("traceId", traceId);
        return traceId;
    }

    public static String generateTraceId(String traceId){
        if (!StringUtils.hasLength(traceId)){
            return generateTraceId();
        }
        MDC.put("traceId", traceId);
        return traceId;
    }

    public static String getTraceId(){
        return MDC.get("traceId");
    }

    public static void removeTraceId(){
        MDC.remove("traceId");
    }
}

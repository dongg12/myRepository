package com.wd.demo.mdc.threadlocal;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.wd.demo.mdc.util.TraceIdUtil;
import org.slf4j.MDC;

public class CustomThreadLocal<T> extends TransmittableThreadLocal<T> {


    @Override
    protected void beforeExecute() {
        MDC.put("traceId", TraceIdUtil.getTraceId());
        super.beforeExecute();
    }
}

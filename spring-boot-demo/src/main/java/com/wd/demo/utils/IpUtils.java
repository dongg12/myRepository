package com.wd.demo.utils;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class IpUtils {
    public static String getRealIp(HttpServletRequest request){
        String ip = request.getHeader("x-forwarded-for");
        if (StringUtils.hasLength(ip) || "unknown".equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }

        return ip;
    }
}

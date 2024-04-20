package com.wd.demo.printParam;

import com.alibaba.fastjson2.JSON;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PrintLogParamDto {
    /**
     * 请求头入参
     */
    private Map<String, Object> headerMap;

    /**
     * 请求体
     */
    private String request;

    /**
     * url
     */
    private String url;

    /**
     * 返回体
     */
    private HttpServletResponse response;

    public String toString() {
        return "\n" + url + "\n" + getHeaderString() + "\n" + request;
    }

    private String getHeaderString() {
        AtomicReference<String> headString = new AtomicReference<>("");
        if (CollectionUtils.isEmpty(headerMap)) {
            return headString.get();
        }
        headerMap.forEach((key, value) -> {
            headString.set(headString + key + ":" + JSON.toJSONString(value) + "\n");
        });
        return headString.get();
    }
}

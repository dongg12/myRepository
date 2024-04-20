package com.wd.demo.mdc.threadlocal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomContext {
    private Map<String, Object> contextMap;

    public Object getByKey(String key) {
        return contextMap.get(key);
    }

    public void putValue(String key,Object value){
        contextMap.put(key, value);
    }
}

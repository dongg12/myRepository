package com.wd.demo.mdc.threadlocal;

public class CustomManager {
    private static final CustomThreadLocal<CustomContext> contextCustomThreadLocal = new CustomThreadLocal<>();

    public static String getRequestNonce(){
        CustomContext customContext = contextCustomThreadLocal.get();
        return (String) customContext.getByKey("x-requestNonce");
    }

    public void putParam(String key,Object value){
        CustomContext customContext = contextCustomThreadLocal.get();
        customContext.putValue(key, value);
    }


}

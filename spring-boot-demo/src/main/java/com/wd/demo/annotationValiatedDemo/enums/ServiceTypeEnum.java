package com.wd.demo.annotationValiatedDemo.enums;

public enum  ServiceTypeEnum {
    FAST("1",1),
    CARD("2",2);

    String code;
    Integer desc;

    ServiceTypeEnum(String code,Integer desc){
        this.code = code;
        this.desc = desc;
    }
}

package com.wd.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.lang.annotation.Before;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
//    @DesensitizationProp(SensitiveTypeEnum.PASSWORD)
    private String password;
//    @DesensitizationProp(SensitiveTypeEnum.MOBILE_PHONE)
    private String phone;
}

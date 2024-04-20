package com.wd.demo.annotationValiatedDemo.annotation;


import com.wd.demo.annotationValiatedDemo.EnumValidator;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EnumValidator.class)
public @interface ValidateEnum {
    Class<?> enumClass();
    String method() default "getCode";
    String message() default "参数不符合规定";
}

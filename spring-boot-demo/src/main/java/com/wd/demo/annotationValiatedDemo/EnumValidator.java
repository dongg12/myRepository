package com.wd.demo.annotationValiatedDemo;

import com.wd.demo.annotationValiatedDemo.annotation.ValidateEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Component
public class EnumValidator implements ConstraintValidator<ValidateEnum, Object> {

    private final List<Object> values = new ArrayList<>();

    @Override
    public void initialize(ValidateEnum constraintAnnotation) {
        Class<?> clazz = constraintAnnotation.enumClass();
        Method method = BeanUtils.findDeclaredMethodWithMinimalParameters(clazz, constraintAnnotation.method());
        assert method != null;
        Object[] enumConstants = clazz.getEnumConstants();
        try {
            for (Object object : enumConstants) {
                values.add(method.invoke(object));
            }
        } catch (IllegalAccessException | InvocationTargetException e) {

        }
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return o == null || values.contains(o);
    }
}

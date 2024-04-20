package com.wd.demo.propertiesParamValidate;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;

@Validated
@Data
@ConfigurationProperties(prefix = "app")
@Component
public class AppConfigProperties {
    @Max(5)
    private Integer id;
}

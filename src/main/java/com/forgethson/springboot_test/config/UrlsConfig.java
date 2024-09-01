package com.forgethson.springboot_test.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "config.urls")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UrlsConfig {
    private String orderUrl;
    private String userUrl;
    private String shoppingUrl;

    @Value("${config.myUrl}")
    private String myUrl;
}

package com.forgethson.springboot_test.Controller;

import com.forgethson.springboot_test.config.UrlsConfig;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试两种读取配置文件的方式
 * */

@RestController
@RequestMapping("/config")
@AllArgsConstructor
public class ConfigController {
    private static final Logger logger = LoggerFactory.getLogger(ConfigController.class);
    // final + AllArgsConstructor 实现自动装配，很简洁
    private final UrlsConfig urlsConfig;


    // 通过@Value获取配置
    @GetMapping("/url")
    public String getUrl() {
        logger.info("getUrl : {}", urlsConfig.getMyUrl());
        return "getUrl :" + urlsConfig.getMyUrl();
    }

    // 通过@ConfigurationProperties获取配置
    @GetMapping("urls")
    public List<String> getUrls() {
        ArrayList<String> res = new ArrayList<>();
        res.add(urlsConfig.getOrderUrl());
        res.add(urlsConfig.getUserUrl());
        res.add(urlsConfig.getShoppingUrl());
        logger.info("getUrls : {}", res);
        return res;
    }

}

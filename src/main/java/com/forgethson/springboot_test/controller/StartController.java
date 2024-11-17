package com.forgethson.springboot_test.controller;

import com.forgethson.springboot_test.annotation.Record;
import com.forgethson.springboot_test.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试两类返回值：String、JSON
 * 测试打印日志
 */

@RestController
@RequestMapping("/start")
@Slf4j
public class StartController {

    // 返回String
    @GetMapping("/helloworld")
    public String helloWorld() {
        log.info("请求：/start/helloworld");
        return "Welcome to the world of Spring Boot!";
    }

    // 返回pojo（转为JSON）
    @GetMapping("/pojo")
    public User getUser() {
        log.info("请求：/start/pojo");
        return new User(1L, "用户1", "123456", true);
    }

    // 返回list（转为JSON）
    @GetMapping("/list")
    public List<User> getUserList() {
        log.info("请求：/start/list");
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "测试用户1", "aaad21414", true);
        User user2 = new User(2L, "测试用户2", "114132412", true);
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    // 返回map（转为JSON）
    @GetMapping("/map")
    public Map<String, Object> getMap() {
        log.info("请求：/start/map");
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "测试用户1", "123456", true);
        map.put("作者信息", user);
        map.put("爱好", "sleep");
        map.put("ID", "Forgethson");
        map.put("github", "https://github.com/Forgethson/");
        return map;
    }

    @PostMapping("/body")
    public User testBody(@RequestBody User user) {
        log.info(user.toString());
        return user;
    }

    // 测试打印log
    @GetMapping("/log")
    public String testLog() {
        log.debug("=====测试日志debug级别打印====");
        log.info("======测试日志info级别打印=====");
        log.error("=====测试日志error级别打印====");
        log.warn("======测试日志warn级别打印=====");
        // 可以使用占位符打印出一些参数信息
        String str1 = "++++++++";
        String str2 = "--------";
        log.info("======测试拼接：{} {}", str1, str2);
        return "success";
    }

    // 测试注解+AOP
    @GetMapping("/annotation")
    @Record("this is me, testAnnotation()")
    public String testAnnotation() {
        return "success";
    }

    // 测试注解+AOP，抛出异常
    @GetMapping("/annotation2")
    @Record("this is me, testAnnotation()2")
    public String testAnnotation2() {
        throw new RuntimeException("testAnnotation2() execute err!");
    }

}

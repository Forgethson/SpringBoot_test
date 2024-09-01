package com.forgethson.springboot_test.Controller;

import com.forgethson.springboot_test.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试两类返回值：String、JSON
 * 测试打印日志
 * */

@RestController
@RequestMapping("/start")
public class StartController {

    private static final Logger logger = LoggerFactory.getLogger(StartController.class);

    // 返回String
    @GetMapping("/helloworld")
    public String helloWorld() {
        logger.info("请求：/start/helloworld");
        return "Welcome to the world of Spring Boot!";
    }

    // 返回pojo（转为JSON）
    @GetMapping("/pojo")
    public User getUser() {
        logger.info("请求：/start/pojo");
        return new User(1L, "用户1", "123456");
    }

    // 返回list（转为JSON）
    @GetMapping("/list")
    public List<User> getUserList() {
        logger.info("请求：/start/list");
        List<User> userList = new ArrayList<>();
        User user1 = new User(1L, "测试用户1", "aaad21414");
        User user2 = new User(2L, "测试用户2", "114132412");
        userList.add(user1);
        userList.add(user2);
        return userList;
    }

    // 返回map（转为JSON）
    @GetMapping("/map")
    public Map<String, Object> getMap() {
        logger.info("请求：/start/map");
        Map<String, Object> map = new HashMap<>(3);
        User user = new User(1L, "测试用户1", "123456");
        map.put("作者信息", user);
        map.put("爱好", "sleep");
        map.put("ID", "Forgethson");
        map.put("github", "https://github.com/Forgethson/");
        return map;
    }

    // 测试打印log
    @RequestMapping("/log")
    public String testLog() {
        logger.debug("=====测试日志debug级别打印====");
        logger.info("======测试日志info级别打印=====");
        logger.error("=====测试日志error级别打印====");
        logger.warn("======测试日志warn级别打印=====");
        // 可以使用占位符打印出一些参数信息
        String str1 = "++++++++";
        String str2 = "--------";
        logger.info("======测试拼接：{} {}", str1, str2);
        return "success";
    }

}

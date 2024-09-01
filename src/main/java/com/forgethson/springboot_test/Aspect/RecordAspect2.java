package com.forgethson.springboot_test.Aspect;

import com.forgethson.springboot_test.Annotation.Record;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 增强Record注解的切面类2（测试order顺序）
 * */

@Component
@Aspect
@Slf4j
@Order(2)
public class RecordAspect2 {

    // 只对Record注解增强
    @Pointcut("@annotation(com.forgethson.springboot_test.Annotation.Record)")
    public void pointcut() {

    }

    // 前置通知
    @Before("pointcut()")
    public void before() {
        log.info("@before：record, RecordAspect2执行");
    }
}

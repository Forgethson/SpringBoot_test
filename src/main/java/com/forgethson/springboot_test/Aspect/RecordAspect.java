package com.forgethson.springboot_test.Aspect;

import com.forgethson.springboot_test.Annotation.Record;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class RecordAspect {
    private static final Logger logger = LoggerFactory.getLogger(RecordAspect.class);

    // 只对指定的注解增强
    @Pointcut("@annotation(com.forgethson.springboot_test.Annotation.Record)")
    public void pointcut() {

    }

    // 环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        if (!method.isAnnotationPresent(Record.class)) {
            logger.error("ERROR：没在使用record注解的方法上调用切面");
            return pjp.proceed(pjp.getArgs());
        }
        Record record = method.getAnnotation(Record.class);
        logger.info("捕捉到record注解的pointcut，value={}",record.value());

        Object res = null;
        logger.info("前置通知：record [before]");
        try {
            // 目标方法执行
            res = pjp.proceed(pjp.getArgs());
            logger.info("返回通知：record [afterReturning]");
        } catch (Throwable e) {
            logger.error("异常通知：record [afterThrowing], err={}", e.getMessage());
        } finally {
            logger.info("后置通知：record [after]");
        }
        return res;
    }
}

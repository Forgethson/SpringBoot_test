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
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Component
@Aspect
@Slf4j
public class RecordAspect {

    // 只对指定的注解增强
    @Pointcut("@annotation(com.forgethson.springboot_test.Annotation.Record)")
    public void pointcut() {

    }

    // 环绕通知
    @Around("pointcut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Method method = ((MethodSignature) pjp.getSignature()).getMethod();
        if (!method.isAnnotationPresent(Record.class)) {
            log.error("ERROR：错误捕获！没在使用record注解的方法上增强");
            return pjp.proceed(pjp.getArgs());
        }
        Record record = method.getAnnotation(Record.class);
        log.info("捕捉到record注解的pointcut，value={}", record.value());

        Object res = null;
        log.info("前置通知：record [before]");
        try {
            // 目标方法执行
            res = pjp.proceed(pjp.getArgs());
            log.info("返回通知：record [afterReturning]");
        } catch (Throwable e) {
            log.error("异常通知：record [afterThrowing], err={}", e.getMessage());
        } finally {
            log.info("后置通知：record [after]");
        }
        return res;
    }

    // 前置通知（写法2）
    @Before("@annotation(record)")
    public void before(JoinPoint joinPoint, Record record) {
        log.info("@before：捕捉到record注解的pointcut，value={}", record.value());
    }
}

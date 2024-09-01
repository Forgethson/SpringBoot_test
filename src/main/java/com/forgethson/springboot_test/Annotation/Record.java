package com.forgethson.springboot_test.Annotation;

import java.lang.annotation.*;

/**
 * 自定义注解 Record
 * */

@Target(ElementType.METHOD) // 限定作用在方法上
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Record {
    String value() default ""; // 这里只有一个annotation type element（注解元素）
}

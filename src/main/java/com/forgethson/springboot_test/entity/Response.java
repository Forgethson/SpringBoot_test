package com.forgethson.springboot_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response<T> success(T data) {
        this.code = 200;
        this.message = "success";
        this.data = data;
        return this;
    }
}

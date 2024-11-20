package com.forgethson.springboot_test.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @NotNull
    private int id;
    @NotNull
    private String name;
}

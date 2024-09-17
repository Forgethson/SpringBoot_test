package com.forgethson.springboot_test.service;

import com.forgethson.springboot_test.entity.Todo;

import java.util.List;

public interface TodoService {
    public List<Todo> getTodoList();

    public int addTodo(Todo todo);

    public int deleteTodo(int id);

    public int toggleTodo(int id);
}

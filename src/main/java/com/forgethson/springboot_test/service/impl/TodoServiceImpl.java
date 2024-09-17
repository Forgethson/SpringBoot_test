package com.forgethson.springboot_test.service.impl;

import com.forgethson.springboot_test.entity.Todo;
import com.forgethson.springboot_test.mapper.TodoMapper;
import com.forgethson.springboot_test.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoMapper todoMapper;

    @Override
    public List<Todo> getTodoList() {
        return todoMapper.selectAllTodos();
    }

    @Override
    public int addTodo(Todo todo) {
        return todoMapper.insert(todo);
    }

    @Override
    public int deleteTodo(int id) {
        return todoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int toggleTodo(int id) {
        return todoMapper.toggleByPrimaryKey(id);
    }
}

package com.forgethson.springboot_test.controller;

import com.forgethson.springboot_test.entity.Response;
import com.forgethson.springboot_test.entity.Todo;
import com.forgethson.springboot_test.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
@Slf4j
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/list")
    public Response<List<Todo>> getTodoList() {
        return new Response<List<Todo>>().success(todoService.getTodoList());
    }

    @PostMapping("/add")
    public Response<Integer> addTodo(@RequestBody Todo todo) {
        return new Response<Integer>().success(todoService.addTodo(todo));
    }

    @PostMapping("/delete/{id}")
    public Response<Integer> deleteTodo(@PathVariable Integer id) {
        return new Response<Integer>().success(todoService.deleteTodo(id));
    }

    @PostMapping("/toggle/{id}")
    public Response<Integer> toggleTodo(@PathVariable Integer id) {
        return new Response<Integer>().success(todoService.toggleTodo(id));
    }
}

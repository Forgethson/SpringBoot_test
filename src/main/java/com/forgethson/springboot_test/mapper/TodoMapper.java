package com.forgethson.springboot_test.mapper;

import com.forgethson.springboot_test.entity.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoMapper {
    int insert(Todo todo);

    int selectByPrimaryKey(Integer id);

    int toggleByPrimaryKey(Integer id);

    List<Todo> selectAllTodos();

    int deleteByPrimaryKey(Integer id);
}

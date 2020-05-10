package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by eswari-3920 on 5/10/2020
 */
@Component
public interface TodoService {

    public List<TodoEntity> retrieveTodos();

    public void saveTodoInfo(TodoEntity todoEntity);

    public void deleteTodoInfo(Long todoId);

    public void updateTodoInfo(TodoEntity todoEntity);

    public TodoEntity getTodo(Long todoId);

    public TodoEntity getTodoByName(String todoName);
}

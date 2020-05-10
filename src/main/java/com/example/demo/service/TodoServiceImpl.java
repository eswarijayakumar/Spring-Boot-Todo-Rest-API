package com.example.demo.service;

import com.example.demo.entity.TodoEntity;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by eswari-3920 on 5/10/2020
 */
@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public void setTodoRepository(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public List<TodoEntity> retrieveTodos() {
        List<TodoEntity> todo = todoRepository.findAll();
        return todo;
    }

    @Override
    public void saveTodoInfo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    @Override
    public void deleteTodoInfo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public void updateTodoInfo(TodoEntity todoEntity) {
        todoRepository.save(todoEntity);
    }

    @Override
    public TodoEntity getTodo(Long todoId){
        Optional<TodoEntity> optTodo = todoRepository.findById(todoId);
        return optTodo.get();
    }

    @Override
    public TodoEntity getTodoByName(String todoName){
        TodoEntity todoEntity = todoRepository.findByTodoName(todoName);
        return todoEntity;
    }
}

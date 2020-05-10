package com.example.demo.controller;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by eswari-3920 on 5/9/2020
 */
@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    public void setTodoService(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/api/todo")
    public List<TodoEntity> getTodos(){
        List<TodoEntity> todoEntities = todoService.retrieveTodos();
        return todoEntities;
    }

    @PostMapping("/api/todo")
    public void saveTodo(TodoEntity todoEntity){
        todoService.saveTodoInfo(todoEntity);
    }

    @DeleteMapping("/api/todo/{todoId}")
    public void deleteTodo(@PathVariable(name = "todoId") Long todoId){
        todoService.deleteTodoInfo(todoId);
    }

    @PutMapping("/api/todo/{todoId}")
    public void updateTodo(@RequestBody TodoEntity todoEntity, @PathVariable(name = "todoId")Long todoId){
        TodoEntity todoEntity1 = todoService.getTodo(todoId);
        if(todoEntity1 != null){
            todoService.updateTodoInfo(todoEntity);
        }
    }

    @RequestMapping(value = "/todo")
    public String helloworld(){
        return "todoindex";
    }
}

package com.example.demo.repository;

import com.example.demo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by eswari-3920 on 5/10/2020
 */
public interface TodoRepository extends JpaRepository<TodoEntity, Long> {

    TodoEntity findByTodoName(String todoName);
}

package com.example.demo.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;

/**
 * Created by eswari-3920 on 5/10/2020
 */
@Component
@Entity
@Table(name="TODO")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TODO_NAME")
    private String todoName;

    @Column(name = "TODO_STATUS")
    private String todoStatus;

    public String getTodoName() {
        return todoName;
    }

    public void setTodoName(String todoName) {
        this.todoName = todoName;
    }


    public String getTodoStatus() {
        return todoStatus;
    }

    public void setTodoStatus(String todoStatus) {
        this.todoStatus = todoStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }


}

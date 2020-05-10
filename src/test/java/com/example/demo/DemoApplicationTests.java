package com.example.demo;

import com.example.demo.entity.TodoEntity;
import com.example.demo.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	TodoService todoService;

	@Test
	void contextLoads() {
	}

	@Test
	public void testSaveTodo(){
		try {
			TodoEntity todoEntity = new TodoEntity();
			todoEntity.setTodoName("Reading");
			todoEntity.setTodoStatus("true");
			todoService.saveTodoInfo(todoEntity);
		}catch (Exception e){
			Assertions.fail();
		}
	}

	@Test
	public void testUpdateTodo(){
		try{
			List<TodoEntity> listOfTodos = todoService.retrieveTodos();
			for(int i = 0; i < listOfTodos.size(); i++){
				TodoEntity todoEntity = listOfTodos.get(i);
				todoEntity.setTodoStatus("false");
				todoService.saveTodoInfo(todoEntity);
			}

			int falseTodos = 0;
			List<TodoEntity> listOfFalseTodos = todoService.retrieveTodos();
			for(int j =0; j < listOfFalseTodos.size(); j++){
				TodoEntity todoEntity = listOfFalseTodos.get(j);
				if(todoEntity.getTodoStatus().equalsIgnoreCase("false")){
					falseTodos++;
				}
			}
			assertEquals(true, falseTodos == listOfTodos.size());
		}catch (Exception e){
			Assertions.fail();
		}
	}

	@Test
	public void testGetAllTodos(){
		List<TodoEntity> todoEntityList = todoService.retrieveTodos();
		assertEquals(true, todoEntityList.size() != 0);
	}

	@Test
	public void testGetOneTodo(){
		TodoEntity todoEntity = todoService.getTodoByName("Reading");
		assertEquals(true, todoEntity != null);
	}

	@Test
	public void deleteAllTodos(){
		try {
			todoService.retrieveTodos().forEach(e -> todoService.deleteTodoInfo(e.getId()));
		}catch (Exception e){
			Assertions.fail();
		}
	}


}

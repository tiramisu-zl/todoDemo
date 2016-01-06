package com.tw.todo.service;

import com.tw.todo.Dao.TodoRepository;
import com.tw.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    private List<Todo> todoList = new ArrayList<Todo>();

    public List<Todo> getTodoList() throws Exception {
        return  todoRepository.query();
    }

    public Todo addTodoItem(int id, String content, Boolean status) throws Exception{
        Todo todo = new Todo(id,content,status);
        try {
            todoRepository.addTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }

    public String delTodoItem(int id) throws Exception{
        try {
            todoRepository.delTodo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public Todo editTodoItem(int id, String content, Boolean status) throws Exception{
        Todo todo = new Todo(id,content,status);
        try {
            todoRepository.updateTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }
}

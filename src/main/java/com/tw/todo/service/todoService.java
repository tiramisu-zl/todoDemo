package com.tw.todo.service;

import com.tw.todo.Dao.TodoRepository;
import com.tw.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private List<Todo> todoList = new ArrayList<Todo>();
    TodoRepository dao = new TodoRepository();

    public List<Todo> getTodoList() throws Exception {
        return  dao.query();
    }

    public String addTodoItem(int id, String content, Boolean status) throws Exception{
        Todo todo = new Todo(id,content,status);
        try {
            dao.addTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public String delTodoItem(int id) throws Exception{
        try {
            dao.delTodo(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    public Todo editTodoItem(int id, String content, Boolean status) throws Exception{
        Todo todo = new Todo(id,content,status);
        try {
            dao.updateTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return todo;
    }
}

package com.tw.todo.Servlet;

import com.alibaba.fastjson.JSON;
import com.tw.todo.Dao.TodoRepository;
import com.tw.todo.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class IndexServlet extends HttpServlet {

    private List<Todo> todoList = new ArrayList<Todo>();
    TodoRepository dao = new TodoRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        try {
            todoList = dao.query();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonTodo = JSON.toJSONString(todoList);
        out.print(jsonTodo);
    }

//    public void addTodo(Todo t) throws Exception {
//        dao.addTodo(t);
//    }
//
//    public void removeTodo(Integer id) throws Exception {
//        dao.delTodo(id);
//    }
//
//    public void updateTodo(Todo t) throws Exception {
//        dao.updateTodo(t);
//    }

}

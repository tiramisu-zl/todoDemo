package com.tw.todo.Servlet;

import com.alibaba.fastjson.JSON;
import com.tw.todo.model.Todo;
import com.tw.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class IndexServlet extends HttpServlet {

    TodoService TodoService = new TodoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        List<Todo> todoList = new ArrayList<Todo>();

        try {
            todoList = TodoService.getTodoList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String jsonTodo = JSON.toJSONString(todoList);
        out.print(jsonTodo);
    }

}

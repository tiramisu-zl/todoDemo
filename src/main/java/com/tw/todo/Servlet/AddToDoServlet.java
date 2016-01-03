package com.tw.todo.Servlet;

import com.tw.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class AddToDoServlet extends HttpServlet {

    TodoService TodoService = new TodoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String content = req.getParameter("content");
        Integer id= 0;
        boolean status = false;

        try {
            String result = TodoService.addTodoItem(id, content, status);
            out.print(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

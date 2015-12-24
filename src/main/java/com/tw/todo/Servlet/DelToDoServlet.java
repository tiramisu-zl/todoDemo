package com.tw.todo.Servlet;

import com.tw.todo.Dao.TodoRepository;
import com.tw.todo.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class DelToDoServlet extends HttpServlet {

    TodoRepository dao = new TodoRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        String id = req.getParameter("id");

        try {
            dao.delTodo(Integer.parseInt(id));
            out.print("success");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

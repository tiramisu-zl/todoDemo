package com.tw.todo.Servlet;

import com.tw.todo.Dao.TodoRepository;
import com.tw.todo.model.Todo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToDoServlet extends HttpServlet {

    TodoRepository dao = new TodoRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String content = req.getParameter("content");
        Integer id= 0;
        boolean status = false;

        Todo todo = new Todo(id,content,status);

        try {
            dao.addTodo(todo);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

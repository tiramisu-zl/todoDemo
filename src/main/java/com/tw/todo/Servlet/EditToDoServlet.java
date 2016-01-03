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


public class EditToDoServlet extends HttpServlet {

    TodoService TodoService = new TodoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");

        Todo todo = new Todo();
        PrintWriter out = resp.getWriter();

        String ids = req.getParameter("id");
        String status = req.getParameter("status");
        String content = req.getParameter("content");
        Integer id = Integer.parseInt(ids);
        Boolean St = !(new Boolean(status));

        try {
            todo = TodoService.editTodoItem(id, content, St);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String jsonTodo = JSON.toJSONString(todo);
        out.print(jsonTodo);

    }

}

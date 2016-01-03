package com.tw.todo.Servlet;

import com.tw.todo.model.Todo;
import com.tw.todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TodoController {
    @Autowired
    private TodoService TodoService;

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody List<Todo> getAllList() throws Exception{
        return TodoService.getTodoList();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public @ResponseBody Todo addTodoItem(@RequestParam String content) throws Exception{
        Integer id= 0;
        boolean status = false;
        return TodoService.addTodoItem(id, content, status);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public @ResponseBody
    String delTodoItem(@RequestParam String id) throws Exception{
        return TodoService.delTodoItem(Integer.parseInt(id));
    }

    @RequestMapping(value = "/edit/{editContent}", method = RequestMethod.POST)
    public @ResponseBody
    Todo editTodoItem( @PathVariable String editContent, @RequestParam String id, @RequestParam String content, @RequestParam String status) throws Exception{
        Integer ID = Integer.parseInt(id);
        Boolean St = new Boolean(status);
        if(editContent.equals("toggle")){
            St = !St;
        }
        return TodoService.editTodoItem(ID, content, St);
    }
}

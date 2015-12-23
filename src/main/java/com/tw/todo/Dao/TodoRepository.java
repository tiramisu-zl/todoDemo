package com.tw.todo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import  com.tw.todo.util.DBUtil;
import com.tw.todo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoRepository {

    public void addTodo(Todo t) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = "insert into todo_table (content, status) value(?,?)";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setString(1, t.getContent());
        ptmt.setBoolean(2, t.getStatus());
        ptmt.execute();
    }

    public void delTodo(Integer id) throws SQLException{
        Connection conn = DBUtil.getConnection();
        String sql = "delete from todo_table where id=?";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);
        ptmt.execute();
    }

    public void updateTodo(Todo t) throws SQLException{
        Connection conn=DBUtil.getConnection();
        String sql="" +
                " update todo_table " +
                " set content=?,status=?" +
                " where id=? ";
        PreparedStatement ptmt=conn.prepareStatement(sql);

        ptmt.setString(1, t.getContent());
        ptmt.setBoolean(2, t.getStatus());
        ptmt.execute();
    }

    public List<Todo> query() throws Exception{
        List<Todo> todoList = new ArrayList<Todo>();
        Connection conn = DBUtil.getConnection();
        String sql = "select * from todo_table";
        PreparedStatement ptmt = conn.prepareStatement(sql);
        ResultSet rs=ptmt.executeQuery();

        Todo t = new Todo();
        while (rs.next()){
            t.setId(rs.getInt("id"));
            t.setContent(rs.getString("Content"));
            t.setStatus(rs.getBoolean("status"));

            todoList.add(t);
        }
        return todoList;
    }

    public Todo get(Integer id) throws SQLException{
        Todo t = new Todo();
        Connection conn = DBUtil.getConnection();
        String sql = " select * from todo_table where id=? ";
        PreparedStatement ptmt = conn.prepareStatement(sql);

        ptmt.setInt(1, id);
        ResultSet rs = ptmt.executeQuery();
        while (rs.next()) {
            t.setId(rs.getInt("id"));
            t.setContent(rs.getString("content"));
            t.setStatus(rs.getBoolean("status"));
        }
        return t;
    }
}

//public class TodoRepository {
//
//    List<Todo> todoList = new ArrayList<Todo>();
//
//    public List<Todo> getAll(){
//        return todoList;
//    }
//
//    public void addTodoItem(Todo item){
//        todoList.add(item);
//    }
//
//    public void delTodoItem(int id){
//        Todo item = this.getItemById(id);
//        todoList.remove(item);
//    }
//
//    public void updateTodoItem(int id){
//        Todo item = getItemById(id);
//    }
//
//    private Todo getItemById(int id) {
//        for(Todo todo:todoList){
//            if(id == todo.getId()){
//                return todo;
//            }
//        }
//        return null;
//    }
//}

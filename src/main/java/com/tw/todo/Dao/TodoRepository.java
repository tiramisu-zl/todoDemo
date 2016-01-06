package com.tw.todo.Dao;

import com.tw.todo.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@Repository
public class TodoRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addTodo(Todo t) throws SQLException{
        String sql = "insert into todo_table (content, status) value(?,?)";
        Object[] params = { t.getContent(), t.getStatus() };
        jdbcTemplate.update(sql, params);
    }

    public void delTodo(Integer id) throws SQLException{
        String sql = "delete from todo_table where id=?";
        Object[] params = { id };
        jdbcTemplate.update(sql,params);
    }

    public void updateTodoStatus(int id, boolean status) throws SQLException{
        String sql="update todo_table " +
                " set status = ?" +
                " where id = ?";
        Object[] params = { status, id };
        jdbcTemplate.update(sql, params);
    }

    public void updateTodoContent(int id, String content) throws SQLException{
        String sql = " update todo_table " +
                " set content=?" +
                " where id=?";
        Object[] params = { content, id };
        jdbcTemplate.update(sql, params);
    }

    public void updateTodo(Todo t) throws SQLException{
        String sql = "update todo_table " +
                " set content=?,status=?" +
                " where id=? ";
        Object[] params = { t.getContent(), t.getStatus(), t.getId() };
        jdbcTemplate.update(sql, params);
    }

    public List<Todo> query() throws Exception{
        String sql = "select * from todo_table";
        final List<Todo> todoList = new ArrayList<Todo>();

        List rows = jdbcTemplate.queryForList(sql);
        Iterator iterator = rows.iterator();
        while (iterator.hasNext()) {
            Map map = (Map) iterator.next();
            Todo t = new Todo();
            t.setId((Integer)map.get("id"));
            t.setContent((String)map.get("content"));
            t.setStatus((Boolean)map.get("status"));

            todoList.add(t);
        }

        return todoList;
    }


    public Todo get(Integer id) throws SQLException{
        String sql = " select * from todo_table where id=? ";
        Object[] params = { id };
        final Todo t = new Todo();

        jdbcTemplate.update(sql, params, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                t.setId(resultSet.getInt("id"));
                t.setContent(resultSet.getString("content"));
                t.setStatus(resultSet.getBoolean("status"));
            }
        });

        return t;
    }
}
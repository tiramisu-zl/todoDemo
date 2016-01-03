package com.tw.todo.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL="jdbc:mysql://127.0.0.1:3306/todo_table?characterEncoding=utf-8";
    private static final String USER="root";
    private static final String PASSWORD="admin";

//    private static final String DRIVER = "org.hsqldb.jdbcDriver";
//    private static final String URL="jdbc:hsqldb:file:todomvc";
//    private static final String USER="root";
//    private static final String PASSWORD="";

//    static {
//        try {
//            //1.加载驱动程序
//            Class.forName(DRIVER);
//            //2.获得数据库连接
//            conn=DriverManager.getConnection(URL, USER, PASSWORD);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

    public static Connection getConnection(){
        Connection connection = null;
        try {
            //1.加载驱动程序
            Class.forName(DRIVER);
            //2.获得数据库连接
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}

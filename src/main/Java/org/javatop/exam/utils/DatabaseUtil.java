package org.javatop.exam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-07-15 21:34
 * @description : 数据库连接工具类
 */
public class DatabaseUtil {
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://180.188.45.71:3306/soft_exam?serverTimezone=Asia/Shanghai&autoReconnect=true&useUnicode=true&characterEncoding=utf-8";
    private static final String USER = "root";
    private static final String PASS = "gzm2001..";

    public static Connection getConnection() throws SQLException {
        // 注册 JDBC 驱动
        try {
            Class.forName(JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            throw new SQLException("JDBC Driver not found.", e);
        }

        // 打开连接
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        return conn;
    }
}
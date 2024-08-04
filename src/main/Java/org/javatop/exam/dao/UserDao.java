package org.javatop.exam.dao;

import org.javatop.exam.utils.DatabaseUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static org.javatop.exam.constant.LoginConstant.*;
import static org.javatop.exam.constant.RegisterConstant.*;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-08-04 15:23
 * @description :
 */
public class UserDao {


    /**
     * 注册用户
     * @param username 用户名
     * @param password 密码
     * @return boolean
     */
    public int registerUser(String username, String password) {
        // 检查用户名是否存在
        String checkUserSql = "select COUNT(*) from user where username = ?";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement checkStmt = conn.prepareStatement(checkUserSql)) {
            checkStmt.setString(1, username);
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // 用户名已存在
                return USERNAME_EXIST;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return REGISTER_FAIL;
        }

        // 注册新用户
        String insertUserSql = "INSERT INTO user (username, password,email) VALUES (?, ?,?)";
        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement insertStmt = conn.prepareStatement(insertUserSql)) {
            insertStmt.setString(1, username);
            insertStmt.setString(2, password);
            insertStmt.setString(3, username+ "@123.com");
            int affectedRows = insertStmt.executeUpdate();
            if (affectedRows > 0) {
                // 注册成功
                return REGISTER_SUCCESS;
            } else {
                // 注册失败
                return REGISTER_FAIL;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // 注册失败
            return REGISTER_FAIL;
        }
    }





    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return int 登录结果，1: 登录成功，-1: 密码错误，2: 用户不存在
     */
    public int loginUser(String username, String password) {
        String checkUserSql = "select * from user where username = ?";
        String checkPasswordSql = "select * from user where username = ? and password = ?";

        try (Connection conn = DatabaseUtil.getConnection();
             PreparedStatement checkUserStmt = conn.prepareStatement(checkUserSql);
             PreparedStatement checkPasswordStmt = conn.prepareStatement(checkPasswordSql)) {

            // 检查用户名是否存在
            checkUserStmt.setString(1, username);
            ResultSet userRs = checkUserStmt.executeQuery();
            if (!userRs.next()) {
                // 用户不存在
                return USER_NOT_EXIST;
            }

            // 检查用户名和密码是否匹配
            checkPasswordStmt.setString(1, username);
            checkPasswordStmt.setString(2, password);
            ResultSet passwordRs = checkPasswordStmt.executeQuery();
            if (passwordRs.next()) {
                // 登录成功
                return LOGIN_SUCCESS;
            } else {
                // 密码错误
                return USER_FAIL;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            // 出现异常时，默认返回用户不存在
            return USER_NOT_EXIST;
        }
    }
}

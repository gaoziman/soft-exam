package org.javatop.exam.entity;

import java.util.Date;
import java.util.Objects;

/**
 * @author : Leo
 * @version 1.0
 * @date 2024-07-12 09:30
 * @description : User实体类
 */
public class User {

    private int id;
    private String username;
    private String email;
    private String password;
    private int deleted;
    private Date createTime;
    private Date updateTime;

    public User(int id, String username, String email, String password, int deleted, Date createTime, Date updateTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.deleted = deleted;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getUsername() {
        return username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", deleted=" + deleted +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

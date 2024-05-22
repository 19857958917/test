package com.example.lastwork.entity;

public class User {
    private String user_code;
    private String user_pwd;

    @Override
    public String toString() {
        return "User{" +
                "user_code='" + user_code + '\'' +
                ", user_pwd='" + user_pwd + '\'' +
                '}';
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_pwd() {
        return user_pwd;
    }

    public void setUser_pwd(String user_pwd) {
        this.user_pwd = user_pwd;
    }
}

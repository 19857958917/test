package com.example.lastwork.entity;

public class UserCarInfo {
    private int user_car_id;
    private String car_code;
    private String user_code;
    private int flag;

    @Override
    public String toString() {
        return "UserCarInfo{" +
                "user_car_id=" + user_car_id +
                ", car_code='" + car_code + '\'' +
                ", user_code='" + user_code + '\'' +
                ", flag=" + flag +
                '}';
    }

    public int getUser_car_id() {
        return user_car_id;
    }

    public void setUser_car_id(int user_car_id) {
        this.user_car_id = user_car_id;
    }

    public String getCar_code() {
        return car_code;
    }

    public void setCar_code(String car_code) {
        this.car_code = car_code;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }
}

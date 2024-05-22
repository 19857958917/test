package com.example.lastwork.entity;

public class UserInfo {
    private String user_code;
    private String user_name;
    private String telephone;
    private int integral;
    private int level;
    private int coupons;

    @Override
    public String toString() {
        return "UserInfo{" +
                "user_code='" + user_code + '\'' +
                ", user_name='" + user_name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", integral=" + integral +
                ", level=" + level +
                ", coupons=" + coupons +
                '}';
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getCoupons() {
        return coupons;
    }

    public void setCoupons(int coupons) {
        this.coupons = coupons;
    }
}

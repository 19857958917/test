package com.example.lastwork.entity;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public class PayHistoryInfo {
    private int pay_id;
    private String user_code;
    private String user_name;
    private String telephone;
    private Timestamp entertime;
    private Timestamp outtime;
    private Time parttime;
    private int money;
    private String car_code;
    private int state;
    private int zhekou;
    private int last_pay;
    private Timestamp pay_time;
    private String who_pay;

    @Override
    public String toString() {
        return "PayHistoryInfo{" +
                "pay_id=" + pay_id +
                ", user_code='" + user_code + '\'' +
                ", user_name='" + user_name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", entertime=" + entertime +
                ", outtime=" + outtime +
                ", parttime=" + parttime +
                ", money=" + money +
                ", car_code='" + car_code + '\'' +
                ", state=" + state +
                ", zhekou=" + zhekou +
                ", last_pay=" + last_pay +
                ", pay_time=" + pay_time +
                ", who_pay='" + who_pay + '\'' +
                '}';
    }

    public int getPay_id() {
        return pay_id;
    }

    public void setPay_id(int pay_id) {
        this.pay_id = pay_id;
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

    public Date getEntertime() {
        return entertime;
    }

    public void setEntertime(Timestamp entertime) {
        this.entertime = entertime;
    }

    public Date getOuttime() {
        return outtime;
    }

    public void setOuttime(Timestamp outtime) {
        this.outtime = outtime;
    }

    public Date getParttime() {
        return parttime;
    }

    public void setParttime(Time parttime) {
        this.parttime = parttime;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCar_code() {
        return car_code;
    }

    public void setCar_code(String car_code) {
        this.car_code = car_code;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getLast_pay() {
        return last_pay;
    }

    public void setLast_pay(int last_pay) {
        this.last_pay = last_pay;
    }

    public int getZhekou() {
        return zhekou;
    }

    public void setZhekou(int zhekou) {
        this.zhekou = zhekou;
    }

    public Timestamp getPay_time() {
        return pay_time;
    }

    public void setPay_time(Timestamp pay_time) {
        this.pay_time = pay_time;
    }

    public String getWho_pay() {
        return who_pay;
    }

    public void setWho_pay(String who_pay) {
        this.who_pay = who_pay;
    }
}

package com.example.lastwork.service;

import com.example.lastwork.entity.PayHistoryInfo;
import com.example.lastwork.entity.User;
import com.example.lastwork.entity.UserCarInfo;
import com.example.lastwork.entity.UserInfo;
import com.example.lastwork.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User checkUser(String user_code, String user_pwd){
        return userMapper.checkUser(user_code,user_pwd);
    }

    public List<UserInfo> getUserInfo(String user_code){
        return userMapper.getUserInfo(user_code);
    }

    public List<UserCarInfo> getUserCarInfo(String user_code, String pos, String page_size){
        return userMapper.getUserCarInfo(user_code,pos,page_size);
    }

    public List<PayHistoryInfo> getPayHistoryListH5(String user_code, String pos, String page_size){
        return userMapper.getPayHistoryListH5(user_code,pos,page_size);
    }

    public List<UserCarInfo> addUserCarInfoH5(String user_code,String car_code){
        return userMapper.addUserCarInfoH5(user_code,car_code);
    }

    public List<UserCarInfo> deleteCarCodeH5(String user_code,String car_code){
        return userMapper.deleteCarCodeH5(user_code,car_code);
    }

    public List<PayHistoryInfo> addPayHistoryEntertimeH5(String user_code,String car_code,String time1,String telephone,String user_name){
        return userMapper.addPayHistoryEntertimeH5(user_code,car_code,time1,telephone,user_name);
    }

    public List<PayHistoryInfo> addPayHistoryOuttimeH5(String user_code,String car_code,String time2,String telephone,String user_name){
        return userMapper.addPayHistoryOuttimeH5(user_code,car_code,time2,telephone,user_name);
    }

    public List<UserCarInfo> changeFlag1(String user_code,String car_code){
        return userMapper.changeFlag1(user_code,car_code);
    }

    public List<UserCarInfo> changeFlag2(String user_code,String car_code){
        return userMapper.changeFlag2(user_code,car_code);
    }

    public int IfCanEnterH5(String user_code){
        return userMapper.IfCanEnterH5(user_code);
    }

    public List<PayHistoryInfo> deleteHistoryH5(String pay_id){
        return userMapper.deleteHistoryH5(pay_id);
    }

    public List<PayHistoryInfo> getDetailsH5(String pay_id){
        return userMapper.getDetailsH5(pay_id);
    }

    public List<PayHistoryInfo> toPayH5(String pay_id, String last_pay, String zhekou,String user_code){
        return userMapper.toPayH5(pay_id,last_pay,zhekou,user_code);
    }

    public List<UserInfo> cutIntegralH5(String user_code){
        return userMapper.cutIntegralH5(user_code);
    }

    public int getCarCodeNumberH5(String user_code){
        return userMapper.getCarCodeNumberH5(user_code);
    }

    public int getPayIdH5(String carnonew){
        return userMapper.getPayIdH5(carnonew);
    }

//----------------------------------------------------------------------------------------------------------------------

    public List<PayHistoryInfo> getPayHistoryList(String user_code, String pos, String page_size){
        return userMapper.getPayHistoryList(user_code,pos,page_size);
    }

    public int getCarCodeNumber(String user_code){
        return userMapper.getCarCodeNumber(user_code);
    }

    public List<UserCarInfo> deleteCarCode(String user_code,String car_code){
        return userMapper.deleteCarCode(user_code,car_code);
    }

    public List<PayHistoryInfo> toPay(String pay_id,int zhekou,String uaer_code){
        return userMapper.toPay(pay_id,zhekou,uaer_code);
    }

    public List<PayHistoryInfo> getDetails(int pay_id){
        return userMapper.getDetails(pay_id);
    }

}

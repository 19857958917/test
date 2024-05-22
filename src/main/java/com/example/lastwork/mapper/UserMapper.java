package com.example.lastwork.mapper;


import com.example.lastwork.entity.PayHistoryInfo;
import com.example.lastwork.entity.User;
import com.example.lastwork.entity.UserCarInfo;
import com.example.lastwork.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    @Select("select * from user_login where user_code=#{userCode} and user_pwd=#{userPwd}")
    User checkUser(@Param("userCode") String user_code,
                   @Param("userPwd") String user_pwd);

    @Select("select * from user_info where user_code=#{user_code}")
    List<UserInfo> getUserInfo(@Param("user_code") String user_code);

    @Select("select * from user_car_info where user_code=#{user_code} limit ${pos},${page_size}")
    List<UserCarInfo> getUserCarInfo(@Param("user_code") String user_code,
                                     @Param("pos") String pos,
                                     @Param("page_size") String page_size);

    @Select("select * from payhistory where user_code=#{user_code} or who_pay=#{user_code} limit ${pos},${page_size}")
    List<PayHistoryInfo> getPayHistoryListH5(@Param("user_code") String user_code,
                                        @Param("pos") String pos,
                                        @Param("page_size") String page_size);

    @Select("insert user_car_info values(null,'${user_code}','${car_code}',null)")
    List<UserCarInfo> addUserCarInfoH5(@Param("user_code") String user_code,
                                       @Param("car_code") String car_code);

    @Select("delete from user_car_info where user_code=${user_code} and car_code='${car_code}'")
    List<UserCarInfo> deleteCarCodeH5(@Param("user_code") String user_code,
                                      @Param("car_code") String car_code);

    @Select("delete from payhistory where pay_id=${pay_id}")
    List<PayHistoryInfo> deleteHistoryH5(@Param("pay_id") String pay_id);

    @Select("insert payhistory values(null,'${user_code}','${user_name}','${telephone}','${time1}',null,null,null,'${car_code}',0,null,null,null,null,1)")
    List<PayHistoryInfo> addPayHistoryEntertimeH5(@Param("user_code") String user_code,
                                         @Param("car_code") String car_code,
                                         @Param("time1") String time1,
                                         @Param("telephone") String telephone,
                                         @Param("user_name") String user_name);

    @Select("update payhistory set outtime='${time2}',parttime=timediff(outtime,entertime),flag=0,money=DATE_FORMAT(parttime,'%H')*7 where flag=1")
    List<PayHistoryInfo> addPayHistoryOuttimeH5(@Param("user_code") String user_code,
                                                  @Param("car_code") String car_code,
                                                  @Param("time2") String time2,
                                                  @Param("telephone") String telephone,
                                                  @Param("user_name") String user_name);

    @Select("update user_car_info set flag=1 where user_code=${user_code} and car_code='${car_code}'")
    List<UserCarInfo> changeFlag1(@Param("user_code") String user_code,
                                  @Param("car_code") String car_code);

    @Select("update user_car_info set flag=0 where user_code=${user_code} and car_code='${car_code}'")
    List<UserCarInfo> changeFlag2(@Param("user_code") String user_code,
                                  @Param("car_code") String car_code);

    @Select("select count(*) from payhistory where state=0 and user_code=${user_code}")
    int IfCanEnterH5(@Param("user_code") String user_code);

    @Select("select * from payhistory where pay_id=${pay_id}")
    List<PayHistoryInfo> getDetailsH5(@Param("pay_id") String pay_id);

    @Select("update payhistory set last_pay=${last_pay},zhekou=${zhekou},state=1,pay_time=now(),who_pay=${user_code} where pay_id=${pay_id}")
    List<PayHistoryInfo> toPayH5(@Param("pay_id") String pay_id,
                                 @Param("last_pay") String last_pay,
                                 @Param("zhekou") String zhekou,
                                 @Param("user_code") String user_code);

    @Select("update user_info set integral=integral-10 where user_code=${user_code}")
    List<UserInfo> cutIntegralH5(@Param("user_code") String user_code);

    @Select("select count(*) from user_car_info where user_code=${user_code}")
    int getCarCodeNumberH5(@Param("user_code") String user_code);

    @Select("select pay_id from payhistory where car_code='${carnonew}' and state=0")
    int getPayIdH5(@Param("carnonew") String carnonew);

//----------------------------------------------------------------------------------------------------------------------

    @Select("select * from payhistory where user_code=#{user_code} or who_pay=#{user_code}  limit ${pos},${page_size}")
    List<PayHistoryInfo> getPayHistoryList(@Param("user_code") String user_code,
                                           @Param("pos") String pos,
                                           @Param("page_size") String page_size);

    @Select("select count(*) from user_car_info where user_code=${user_code}")
    int getCarCodeNumber(@Param("user_code") String user_code);

    @Select("delete from user_car_info where user_code=${user_code} and car_code='${car_code}'")
    List<UserCarInfo> deleteCarCode(@Param("user_code") String user_code,
                                      @Param("car_code") String car_code);

    @Select("update payhistory set last_pay=money-${zhekou},zhekou=${zhekou},state=1,pay_time=now(),who_pay=${user_code} where pay_id=${pay_id}")
    List<PayHistoryInfo> toPay(@Param("pay_id") String pay_id,
                               @Param("zhekou") int zhekou,
                               @Param("user_code") String user_code);

    @Select("select * from payhistory where pay_id=${pay_id}")
    List<PayHistoryInfo> getDetails(@Param("pay_id") int pay_id);
}

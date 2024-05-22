package com.example.lastwork.controller;

import com.example.lastwork.entity.PayHistoryInfo;
import com.example.lastwork.entity.User;
import com.example.lastwork.entity.UserCarInfo;
import com.example.lastwork.entity.UserInfo;
import com.example.lastwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("check_login_h5")
    @ResponseBody
    public int checkLoginH5(HttpServletRequest request, RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String user_pwd = request.getParameter("user_pwd");
        int flag = 0;
        User user = null;
        user = userService.checkUser(user_code,user_pwd);
        if (user != null){
            System.out.println(user.toString());
        }
        if (user != null){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",user);
            attributes.addAttribute("user_code",user_code);
            flag = 1;
            return flag;
        }else {
            flag = 0;
            return flag;
        }
    }

    @RequestMapping("user_info_h5")
    @ResponseBody
    public List<UserInfo> getUserInfo(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        return userInfoList;
    }


    @RequestMapping("user_car_info_h5")
    @ResponseBody
    public List<UserCarInfo> getUserCarInfo(HttpServletRequest request) {
        String user_code = request.getParameter("user_code");
        String pos = request.getParameter("pos");
        String page_size = request.getParameter("page_size");
        List<UserCarInfo> userCarInfoList =
                userService.getUserCarInfo(user_code,pos, page_size);
        return userCarInfoList;
    }

    @RequestMapping("payhistory_list_h5")
    @ResponseBody
    public List<PayHistoryInfo> getPayHistoryList(HttpServletRequest request) {
        String user_code = request.getParameter("user_code");
        String pos = request.getParameter("pos");
        String page_size = request.getParameter("page_size");
        List<PayHistoryInfo> payHistoryList =
                userService.getPayHistoryListH5(user_code,pos, page_size);
        return payHistoryList;
    }

    @RequestMapping("add_user_car_info_h5")
    @ResponseBody
    public List<UserCarInfo> addUserCarInfoH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        List<UserCarInfo> userCarInfoList = userService.addUserCarInfoH5(user_code,car_code);
        return userCarInfoList;
    }

    @RequestMapping("delete_car_code_h5")
    @ResponseBody
    public List<UserCarInfo> deleteCarCodeH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        List<UserCarInfo> userCarInfoList = userService.deleteCarCodeH5(user_code,car_code);
        return userCarInfoList;
    }

    @RequestMapping("delete_history_h5")
    @ResponseBody
    public List<PayHistoryInfo> deleteHistoryH5(HttpServletRequest request){
        String pay_id = request.getParameter("pay_id");
        List<PayHistoryInfo> payHistoryInfoList = userService.deleteHistoryH5(pay_id);
        return payHistoryInfoList;
    }

    @RequestMapping("get_details_h5")
    @ResponseBody
    public List<PayHistoryInfo> getDetailsListH5(HttpServletRequest request){
        String pay_id = request.getParameter("pay_id");
        List<PayHistoryInfo> payHistoryInfoList = userService.getDetailsH5(pay_id);
        return payHistoryInfoList;
    }

    @RequestMapping("to_pay_h5")
    @ResponseBody
    public String toPayH5(HttpServletRequest request){
        String pay_id = request.getParameter("pay_id");
        String last_pay = request.getParameter("last_pay");
        String zhekou = request.getParameter("zhekou");
        String user_code = request.getParameter("user_code");
        List<PayHistoryInfo> payHistoryInfoList = userService.toPayH5(pay_id,last_pay,zhekou,user_code);
        List<UserInfo> userInfoList = userService.cutIntegralH5(user_code);
        return "";
    }

    @RequestMapping("to_pay_h5_2")
    @ResponseBody
    public String toPayH5_2(HttpServletRequest request){
        String pay_id = request.getParameter("pay_id");
        String last_pay = request.getParameter("last_pay");
        String zhekou = request.getParameter("zhekou");
        String user_code = request.getParameter("user_code");
        List<PayHistoryInfo> payHistoryInfoList = userService.toPayH5(pay_id,last_pay,zhekou,user_code);
        return "";
    }

    @RequestMapping("add_pay_history_entertime_h5")
    @ResponseBody
    public String addPayHistoryEntertimeH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        String time1 = request.getParameter("time1");
        String telephone = request.getParameter("telephone");
        String user_name = request.getParameter("user_name");
        List<PayHistoryInfo> payHistoryInfoList = userService.addPayHistoryEntertimeH5(user_code,car_code,time1,telephone,user_name);
        List<UserCarInfo> userCarInfoList = userService.changeFlag1(user_code,car_code);
        return "";
    }

    @RequestMapping("add_pay_history_outtime_h5")
    @ResponseBody
    public String addPayHistoryOuttimeH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        String time2 = request.getParameter("time2");
        String telephone = request.getParameter("telephone");
        String user_name = request.getParameter("user_name");
        List<PayHistoryInfo> payHistoryInfoList = userService.addPayHistoryOuttimeH5(user_code,car_code,time2,telephone,user_name);
        List<UserCarInfo> userCarInfoList = userService.changeFlag2(user_code,car_code);
        return "";
    }


    @RequestMapping("if_can_enter")
    @ResponseBody
    public int ifCanEnterH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        int info = userService.IfCanEnterH5(user_code);
        return info;
    }

    @RequestMapping("car_code_number_h5")
    @ResponseBody
    public int getCarCodeNumberH5(HttpServletRequest request){
        String user_code = request.getParameter("user_code");
        int carCodeNumber = userService.getCarCodeNumberH5(user_code);
        System.out.println(carCodeNumber);
        return carCodeNumber;
    }

    @RequestMapping("get_pay_id_h5")
    @ResponseBody
    public int getPayIdH5(HttpServletRequest request){
        String carnonew = request.getParameter("carnonew");
        int pay_id = userService.getPayIdH5(carnonew);
        return pay_id;
    }

//----------------------------------------------------------------------------------------------------------------------

    @RequestMapping("show_user_login")
    public String showJwLogin(){
        return "user_login";
    }

    @RequestMapping("check_login")
    public String checkLogin(HttpServletRequest request, RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String user_pwd = request.getParameter("user_pwd");
        System.out.println("前端的数据:" + user_code + "-----" + user_pwd);

        User user = null;
        user = userService.checkUser(user_code,user_pwd);
        if (user != null){
            System.out.println(user.toString());
        }
        if (user != null){
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("user",user);
            attributes.addAttribute("user_code",user_code);
            attributes.addAttribute("pos",0);
            attributes.addAttribute("page_size",10);
            return "redirect:user_info";
        }else {

            return "redirect:show_user_login";
        }
    }

    @RequestMapping("user_info")
    public String getUserVerifyInfo(HttpServletRequest request, Model model){
        String user_code = request.getParameter("user_code");
        String pos = request.getParameter("pos");
        String page_size = request.getParameter("page_size");
        System.out.println(user_code);
        int notpaid = userService.IfCanEnterH5(user_code);
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<UserCarInfo> userCarInfoList = userService.getUserCarInfo(user_code,pos, page_size);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_car_info",userCarInfoList);
        model.addAttribute("user_code",user_code);
        model.addAttribute("notpaid",notpaid);
        return "user_verify_info";
    }

    @RequestMapping("get_user_payhistiry")
    public String getUserPayhistiry(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        System.out.println(user_code);
        String pos = "0";
        String page_size = "100";
        List<PayHistoryInfo> payHistoryList =
                userService.getPayHistoryList(user_code,pos, page_size);
        model.addAttribute("payhistorylist",payHistoryList);
        model.addAttribute("user_code",user_code);
        return "payhistory";
    }

    @RequestMapping("back")
    public String back(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        System.out.println(user_code);
        String pos = "0";
        String page_size = "5";
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<UserCarInfo> userCarInfoList = userService.getUserCarInfo(user_code,pos, page_size);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_car_info",userCarInfoList);
        model.addAttribute("user_code",user_code);
        return "user_verify_info";
    }

    @RequestMapping("enter_time")
    public String addEnterTime(HttpServletRequest request,Model model){
        Date date1 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date1));
        String user_code = request.getParameter("user_code");
        String pos = "0";
        String page_size = "5";

        String car_code = request.getParameter("car_code");
        String user_name = request.getParameter("user_name");
        String telephone = request.getParameter("telephone");
        String enter_time = formatter.format(date1);
        List<PayHistoryInfo> payHistoryInfoList = userService.addPayHistoryEntertimeH5(user_code,car_code,enter_time,telephone,user_name);
        List<UserCarInfo> userCarInfoList1 = userService.changeFlag1(user_code,car_code);
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<UserCarInfo> userCarInfoList = userService.getUserCarInfo(user_code,pos, page_size);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_car_info",userCarInfoList);
        model.addAttribute("user_code",user_code);
        return "user_verify_info";
    }

    @RequestMapping("out_time")
    public String addOutTime(HttpServletRequest request,Model model){
        Date date2 = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date2));
        String user_code = request.getParameter("user_code");
        String pos = "0";
        String page_size = "5";

        String car_code = request.getParameter("car_code");
        String user_name = request.getParameter("user_name");
        String telephone = request.getParameter("telephone");
        String out_time = formatter.format(date2);
        List<PayHistoryInfo> payHistoryInfoList = userService.addPayHistoryOuttimeH5(user_code,car_code,out_time,telephone,user_name);
        List<UserCarInfo> userCarInfoList1 = userService.changeFlag2(user_code,car_code);
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<UserCarInfo> userCarInfoList = userService.getUserCarInfo(user_code,pos, page_size);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_car_info",userCarInfoList);
        model.addAttribute("user_code",user_code);
        return "user_verify_info";
    }

    @RequestMapping("manage_car_code")
    public String manageCarCode(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        String pos = "0";
        String page_size = "5";
        System.out.println(user_code);
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<UserCarInfo> userCarInfoList = userService.getUserCarInfo(user_code,pos, page_size);
        int carCodeNumber = userService.getCarCodeNumber(user_code);
        System.out.println(carCodeNumber);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_car_info",userCarInfoList);
        model.addAttribute("user_code",user_code);
        model.addAttribute("car_code_number",carCodeNumber);
        return "manage_car_code_list";
    }

    @RequestMapping("delete_car_code")
    public String deleteCarCode(HttpServletRequest request,Model model,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        List<UserCarInfo> userCarInfoList = userService.deleteCarCode(user_code,car_code);
        model.addAttribute("user_code",user_code);
        attributes.addAttribute("user_code",user_code);
        return "redirect:manage_car_code";
    }

    @RequestMapping("to_add_car_code")
    public String toAddCarCode(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        model.addAttribute("user_code",user_code);
        return "add_car_code_web";
    }

    @RequestMapping("add_new_car_code")
    public String addCarCode(HttpServletRequest request,Model model,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        System.out.println(car_code);
        List<UserCarInfo> userCarInfoList = userService.addUserCarInfoH5(user_code,car_code);
        attributes.addAttribute("user_code",user_code);
        return "redirect:manage_car_code";
    }

    @RequestMapping("to_pay")
    public String toPay(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        System.out.println(user_code);
        String pay_id = request.getParameter("pay_id");
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<PayHistoryInfo> payHistoryInfoList = userService.getDetailsH5(pay_id);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_code",user_code);
        model.addAttribute("pay_id",pay_id);
        model.addAttribute("payInfo",payHistoryInfoList);
        return "pay_menu";
    }

    @RequestMapping("pay")
    public String payForMoney(HttpServletRequest request,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String pay_id = request.getParameter("pay_id");
        System.out.println(pay_id);
        int zhekou1 = 0;
        if (request.getParameter("zhekou1") != null){
            zhekou1 = Integer.parseInt(request.getParameter("zhekou1"));
        }
        int zhekou2 = 0;
        if (request.getParameter("zhekou2") != null){
            zhekou2 = Integer.parseInt(request.getParameter("zhekou2"));
        }
        int zhekou = zhekou1+zhekou2;

        List<PayHistoryInfo> payHistoryInfoList = userService.toPay(pay_id,zhekou,user_code);
        if (request.getParameter("zhekou2") != null){
            List<UserInfo> userInfoList = userService.cutIntegralH5(user_code);
        }
        System.out.println(zhekou);
        attributes.addAttribute("user_code",user_code);
        return "redirect:get_user_payhistiry";
    }

    @RequestMapping("get_detail")
    public String getDetail(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        String pay_id = request.getParameter("pay_id");
        System.out.println(user_code);
        List<PayHistoryInfo> payHistoryInfoList = userService.getDetailsH5(pay_id);
        model.addAttribute("user_code",user_code);
        model.addAttribute("pay_id",pay_id);
        model.addAttribute("payInfo",payHistoryInfoList);
        return "pay_history_detail";
    }

    @RequestMapping("back_pay_history")
    public String backPayHistory(HttpServletRequest request,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        System.out.println(user_code);
        attributes.addAttribute("user_code",user_code);
        return "redirect:get_user_payhistiry";
    }

    @RequestMapping("back1")
    public String back1(HttpServletRequest request,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        attributes.addAttribute("user_code",user_code);
        return "redirect:manage_car_code";
    }

    @RequestMapping("back2")
    public String back2(HttpServletRequest request,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        attributes.addAttribute("user_code",user_code);
        attributes.addAttribute("pos",0);
        attributes.addAttribute("page_size",10);
        return "redirect:user_info";
    }

    @RequestMapping("delete_history")
    public String deleteHistory(HttpServletRequest request,RedirectAttributes attributes){
        String user_code = request.getParameter("user_code");
        String pay_id = request.getParameter("pay_id");
        System.out.println(user_code);
        List<PayHistoryInfo> payHistoryInfoList = userService.deleteHistoryH5(pay_id);
        attributes.addAttribute("user_code",user_code);
        return "redirect:get_user_payhistiry";
    }

//    @RequestMapping("add_pay")
//    public String addPay(HttpServletRequest request,RedirectAttributes attributes){
//        String user_code = request.getParameter("user_code");
//        String enter_time = request.getParameter("enter_time");
//        String out_time = request.getParameter("out_time");
//        String car_code = request.getParameter("car_code");
//        String user_name = request.getParameter("user_name");
//        String telephone = request.getParameter("telephone");
//        System.out.println(user_code+"--"+enter_time+"--"+out_time+"--"+car_code+"--"+user_name+"--"+telephone);
//        List<PayHistoryInfo> payHistoryInfoList = userService.addPayHistoryH5(user_code,car_code,enter_time,out_time,telephone,user_name);
//        attributes.addAttribute("user_code",user_code);
//        return "redirect:get_user_payhistiry";
//    }

    @RequestMapping("search_friend_pay")
    public String searchFriendPay(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        model.addAttribute("user_code",user_code);
        return "search_pay";
    }

    @RequestMapping("pay_for_friend")
    public String payForFriend(HttpServletRequest request,Model model){
        String user_code = request.getParameter("user_code");
        String car_code = request.getParameter("car_code");
        int pay_id = userService.getPayIdH5(car_code);
        List<UserInfo> userInfoList = userService.getUserInfo(user_code);
        List<PayHistoryInfo> payHistoryInfoList = userService.getDetails(pay_id);
        model.addAttribute("user_info",userInfoList);
        model.addAttribute("user_code",user_code);
        model.addAttribute("pay_id",pay_id);
        model.addAttribute("payInfo",payHistoryInfoList);
        return "pay_for_friend_web";
    }
}

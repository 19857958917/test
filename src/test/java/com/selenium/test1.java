package com.selenium;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        String year = null;//年份
        String month = null;//月份
        String day = null;//日
        boolean result=true;
        boolean result1=true;
        boolean result2=true;
        //输入年月日
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);


        //判断年份
        while (result) {
            try {
                System.out.println("请输入年份:1900-2050：");
                year=scanner1.next();
                //强制转换成int类型
                int year1 = Integer.parseInt(year);
                result = PanduanYear(year1);//判断段年份
                if(result==true){
                    result=false;
                }else {
                    result=true;
                    System.out.println("输入年份超出范围,请重新输入:");
                }

            } catch (Exception e) {
                System.out.println("年份输入有误,请输入正确的年份");

            }
        }


        //判断月份
        while (result1) {
            System.out.println("请输入月份1-12：");
            month = scanner2.next();
            try {
                //强制转换成int类型
                int month1 = Integer.parseInt(month);
                result1 = PanduanMonth(month1);
                if (result1 == true) {
                    result1 = false;
                } else {
                    result1 = true;
                    System.out.println("输入月份超出范围,请重新输入:");
                }
            } catch (Exception e) {
                System.out.println("月份输入有误,请输入正确的月份");
            }
        }

        //判断日期
        while (result2) {
            System.out.println("请输入日：");
            day = scanner3.next();
            try {
                //强制转换成int类型
                int year1 = Integer.parseInt(year);
                int month1 = Integer.parseInt(month);
                int day1 = Integer.parseInt(day);
                result2 = PanDay(year1, month1, day1);
                if (result2 == true) {
                    result2=false;
                }else {
                    result2 = true;
                    System.out.println("输入日期超出范围,请重新输入:");
                }
            } catch (Exception e) {
                System.out.println("日期输入有误,请输入正确的日期");
            }
        }

        SimpleDateFormat fmt = new SimpleDateFormat("dd MM yyyy");

        Date d = null;
        try {
            d = fmt.parse(day+" "+month+" "+year);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Calendar cal = Calendar.getInstance();

        cal.setTime(d);

        int weekDay = cal.get(Calendar.DAY_OF_WEEK);

        switch(weekDay) {
            case 1 : System.out.println("星期天"); break;
            case 2 : System.out.println("星期一"); break;
            case 3 : System.out.println("星期二"); break;
            case 4 : System.out.println("星期三"); break;
            case 5 : System.out.println("星期四"); break;
            case 6 : System.out.println("星期五"); break;
            case 7 : System.out.println("星期六"); break;
            default: break;
        }
    }
    //判断合理的年份
    public static boolean PanduanYear (Integer year){
        return year >= 1900 && year <= 2050;
    }

    //判断月份是否正常
    public static boolean PanduanMonth (Integer month){
        return month >= 1 && month <= 12;
    }



    //判断日期是否输入正常
    public static boolean PanDay(Integer year,Integer month ,Integer day){
        int run=0;//0是平年,1是闰年
        int m=0;//0是31天,1是30天,2是29天,3是28天
        boolean result = false;
        if(year%400==0||year%4==0){
            run=1;
        }
        if(month==4||month==6||month==9||month==11){
            m=1;
        }
        if(month==2&&run==1){
            m=2;
        }
        if (month==2&&run==0){
            m=3;
        }

        if (m==1&&day>=1&&day<=30){
            result=true;
        }

        if (m==0&&day>=1&&day<=31){
            result=true;
        }

        if (m==2&&day>=1&&day<=29){
            result=true;
        }

        if (m==3&&day>=1&&day<=28){
            result=true;
        }

        return result;
    }



}

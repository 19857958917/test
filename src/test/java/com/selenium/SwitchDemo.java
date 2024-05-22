package com.selenium;

import java.util.*;
public class SwitchDemo {
    public static void main(String[] args){
        System.out.println("请输入正整数");
        Scanner kb = new Scanner(System.in);
        int i;
        int n = kb.nextInt();
        if (n <= 1) { // 0 和 1 不是素数
            System.out.println(n + "不是素数");
            return;
        }
        int k = (int) Math.sqrt(n);
        for(i=2;i<=k;i++){
            if(n%i==0){
                break;
            }
        }
        if(i>k){
            System.out.println(n+"是素数");
        } else{
            System.out.println(n+"不是素数");
        }

    }
}

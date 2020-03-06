package com.jike.recharge.view;

import com.jike.recharge.controller.RechargeRecordController;
import com.jike.util.CMUtil;

import java.util.Scanner;

public class RechargeRecordView {
    RechargeRecordController rechargeRecordController=new RechargeRecordController();
    public void start(){
        boolean flag=true;
        while (flag){
        System.out.println("【欢迎使用地铁充值自助机系统】\n" +
                "0 初始化表结构\n" +
                "1 充值\n" +
                "2 刷卡\n" +
                "3 账户详情\n" +
                "4 系统退出\n" +
                "请选择：");


           char c = CMUtil.getUserAction();
           switch (c){
               case '0':
                   System.out.println("------------初始化表结构------------------");
                   break;
               case '1':
                   rechargeRecordController.recharge();
                   break;
               case '2':
                   rechargeRecordController.consume();
                   break;
               case '3':
                   rechargeRecordController.accountDetail();
                   break;
               case '4':
                   flag=false;
                   break;
                   default:
                       break;
           }
       }
    }


}

package com.jike.recharge.controller;

import com.jike.constant.BussinessConst;
import com.jike.recharge.domian.RechargeRecordEntity;
import com.jike.recharge.service.RechargeRecordService;
import com.jike.recharge.service.impl.RechargeRecordServiceImpl;
import com.jike.util.CMUtil;
import com.jike.util.ResultValue;

import javax.swing.*;
import java.util.List;

public class RechargeRecordController {
    RechargeRecordService rechargeRecordService=new RechargeRecordServiceImpl();
    /**
     * 充值地铁
     */
    public void recharge(){
        //循环标识
        boolean flag=true;
        while (flag){
            System.out.println("--------------------------");
            System.out.println("输入yes 进行充值，输入bye 退出程序");
            String operation=CMUtil.readString(3);
            switch (operation.toUpperCase()){
                case BussinessConst.USER_OPERATION_FLAG_YES:
                    System.out.println("请输入地铁卡号：");
                    int cardId=CMUtil.readInt();
                    System.out.println("请输入要充值的金额");
                    double money=CMUtil.readDouble();
                    //调用充值方法
                    ResultValue resultValue = rechargeRecordService.recharge(cardId, money);
                    if(resultValue.getResult()){
                        //充值成功操作
                        JOptionPane.showMessageDialog(null,"充值成功：充值"+resultValue.getValue(),"卡号："+cardId,JOptionPane.PLAIN_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(null,resultValue.getMsg(),"卡号："+cardId,JOptionPane.PLAIN_MESSAGE);
                    }
                    break;
                case BussinessConst.USER_OPERATION_FLAG_BYE:
                    flag=false;
                    System.out.println("感谢您的使用");
                    break;
                    default:
                        System.out.println("输入错误，请重新输入");
            }
        }
    }

    /**
     * 刷卡
     */

    public void consume(){
        //循环标识
        boolean flag=true;
        while (flag){
            System.out.println("--------------------------");
            System.out.println("输入yes 进行刷卡，输入bye 退出程序");
            String operation=CMUtil.readString(3);
            switch (operation.toUpperCase()){
                case BussinessConst.USER_OPERATION_FLAG_YES:
                    System.out.println("请输入地铁卡号：");
                    int cardId=CMUtil.readInt();
                    //调用刷卡方法
                    ResultValue resultValue = rechargeRecordService.consumption(cardId, 5);
                    if(resultValue.getResult()){
                        //刷卡成功操作
                        JOptionPane.showMessageDialog(null,"刷卡成功：刷卡"+resultValue.getValue(),"卡号："+cardId,JOptionPane.PLAIN_MESSAGE);
                    }else {
                        //刷卡失败操作
                        JOptionPane.showMessageDialog(null,resultValue.getMsg(),"卡号："+cardId,JOptionPane.PLAIN_MESSAGE);
                    }
                    break;
                case BussinessConst.USER_OPERATION_FLAG_BYE:
                    flag=false;
                    System.out.println("感谢您的使用");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }

    public void accountDetail(){
        System.out.println("----------当前所有地铁卡充值刷卡记录--------------");
        List<RechargeRecordEntity> rechargeRecordEntities = rechargeRecordService.queryAll();
        rechargeRecordEntities.forEach(rechargeRecordEntity -> {
            System.out.println("卡号："+rechargeRecordEntity.getId()+
                    "\t类型："+rechargeRecordEntity.getType()+
                    "\t余额："+rechargeRecordEntity.getAftMoney()+
                    "\t交易时间："+rechargeRecordEntity.getTransactionTime());
        });

    }
}

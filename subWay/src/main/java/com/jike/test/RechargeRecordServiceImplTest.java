package com.jike.test;

import com.jike.recharge.domian.RechargeRecordEntity;
import com.jike.recharge.service.RechargeRecordService;
import com.jike.recharge.service.impl.RechargeRecordServiceImpl;

import java.util.List;

public class RechargeRecordServiceImplTest {
    public static void main(String[] args) {
        RechargeRecordServiceImplTest rechargeRecordServiceImplTest = new RechargeRecordServiceImplTest();
        rechargeRecordServiceImplTest.retriveAll();
    }

    private void retriveAll() {
        RechargeRecordService rechargeRecordService = new RechargeRecordServiceImpl();
        List<RechargeRecordEntity> rechargeRecordEntities = rechargeRecordService.queryAll();
        for(RechargeRecordEntity rechargeRecordEntity:rechargeRecordEntities){
            System.out.println("卡号："+rechargeRecordEntity.getId()+
                    "\t类型："+rechargeRecordEntity.getType()+
                    "\t余额："+rechargeRecordEntity.getAftMoney()+
                    "\t交易时间："+rechargeRecordEntity.getTransactionTime());
        }
    }
}

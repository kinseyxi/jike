package com.jike.recharge.service.impl;

import com.jike.recharge.dao.RechargeRecordDaoImpl;
import com.jike.recharge.domian.RechargeRecordEntity;
import com.jike.recharge.service.RechargeRecordService;
import com.jike.util.ResultValue;

import java.util.List;

public class RechargeRecordServiceImpl implements RechargeRecordService {
    RechargeRecordDaoImpl rechargeRecordDao= new RechargeRecordDaoImpl();
    @Override
    public ResultValue recharge(int cardId, double money) {
        ResultValue resultValue=new ResultValue();
        RechargeRecordEntity rechargeRecordEntity=rechargeRecordDao.getRechargeRecordById(cardId);
        boolean result;
        //首次充值
        if(rechargeRecordEntity==null){
            result=rechargeRecordDao.addRechargeRecord(cardId,money);
            resultValue.setValue(money+"");
        }else {
            //非首次充值
            result=rechargeRecordDao.updateRechargeRecord(rechargeRecordEntity,money,true);
            resultValue.setValue(money+"");
        }
        if(!result){
            resultValue.setMsg("充值失败，请联系客服");
        }
        resultValue.setResult(result);

        return resultValue;
    }

    @Override
    public ResultValue consumption(int cardId, double money) {
        ResultValue resultValue=new ResultValue();
        RechargeRecordEntity rechargeRecordEntity=rechargeRecordDao.getRechargeRecordById(cardId);
        boolean result=false;
        //卡号不存在
        if(rechargeRecordEntity==null){
            resultValue.setResult(false);
            resultValue.setMsg("卡号："+cardId+"不存在！，请先办卡后方可刷卡");
            return resultValue;
        }else {
            //卡号正常，可以刷卡
            result=rechargeRecordDao.updateRechargeRecord(rechargeRecordEntity,money,false);
            resultValue.setValue(money+"");
        }
        if(!result){
            resultValue.setMsg("刷卡失败，请联系客服");
        }
        resultValue.setResult(result);

        return resultValue;
    }

    @Override
    public List<RechargeRecordEntity> queryAll() {
        return rechargeRecordDao.queryAllRechargeRecord();
    }
}

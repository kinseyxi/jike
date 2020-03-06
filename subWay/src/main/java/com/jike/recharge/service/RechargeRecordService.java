package com.jike.recharge.service;

import com.jike.recharge.domian.RechargeRecordEntity;
import com.jike.util.ResultValue;

import java.util.List;

public interface RechargeRecordService {
    //充值
    ResultValue recharge(int cardId,double money);

    //刷卡
    ResultValue consumption(int cardId,double money);

    //查询当前所有地铁卡充值刷卡记录
    List<RechargeRecordEntity> queryAll();
}

package com.jike.recharge.domian;

import java.sql.Timestamp;

public class RechargeRecordEntity {
    private Integer id; //卡号
    private String type; //类型
    private Double preMoney; //充值前金额
    private Double aftMoney; //充值后金额
    private String line; // 线路
    private String dotName; //网点名称
    private int dotNumber; //网点编号
    private String equipmentName; //设备名称
    private int equipmentNumber; //设备编号
    private Timestamp transactionTime; //交易时间

    public RechargeRecordEntity() {
    }

    public RechargeRecordEntity(Integer id, String type, Double preMoney, Double aftMoney, String line, String dotName, int dotNumber, String equipmentName, int equipmentNumber, Timestamp transactionTime) {
        this.id = id;
        this.type = type;
        this.preMoney = preMoney;
        this.aftMoney = aftMoney;
        this.line = line;
        this.dotName = dotName;
        this.dotNumber = dotNumber;
        this.equipmentName = equipmentName;
        this.equipmentNumber = equipmentNumber;
        this.transactionTime = transactionTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPreMoney() {
        return preMoney;
    }

    public void setPreMoney(Double preMoney) {
        this.preMoney = preMoney;
    }

    public Double getAftMoney() {
        return aftMoney;
    }

    public void setAftMoney(Double aftMoney) {
        this.aftMoney = aftMoney;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDotName() {
        return dotName;
    }

    public void setDotName(String dotName) {
        this.dotName = dotName;
    }

    public int getDotNumber() {
        return dotNumber;
    }

    public void setDotNumber(int dotNumber) {
        this.dotNumber = dotNumber;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public int getEquipmentNumber() {
        return equipmentNumber;
    }

    public void setEquipmentNumber(int equipmentNumber) {
        this.equipmentNumber = equipmentNumber;
    }

    public Timestamp getTransactionTime() {
        return transactionTime;
    }

    public void setTransactionTime(Timestamp transactionTime) {
        this.transactionTime = transactionTime;
    }
}

package com.jike.recharge.dao;

import com.jike.recharge.domian.RechargeRecordEntity;
import com.jike.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RechargeRecordDaoImpl {
    PreparedStatement ps=null;
    ResultSet rs=null;
    Connection conn=null;
    public List<RechargeRecordEntity> queryAllRechargeRecord(){
        conn = JDBCUtil.getMysqlConn();
        List<RechargeRecordEntity> rechargeRecordEntities=new ArrayList<>();
        String sql="select id,type,pre_money,aft_money,line,dot_name,dot_number,equipment_name,"+
                "equipment_number,transaction_time from tb_recharge_record";

        try {
            //预编译处理
            ps = conn.prepareStatement(sql);
            //查询数据表
             rs = ps.executeQuery();
             while (rs.next()){
                 RechargeRecordEntity rechargeRecordEntity = new RechargeRecordEntity();
                 rechargeRecordEntity.setId(rs.getInt(1));
                 rechargeRecordEntity.setType(rs.getString(2));
                 rechargeRecordEntity.setPreMoney(rs.getDouble(3));
                 rechargeRecordEntity.setAftMoney(rs.getDouble(4));
                 rechargeRecordEntity.setLine(rs.getString(5));
                 rechargeRecordEntity.setDotName(rs.getString(6));
                 rechargeRecordEntity.setDotNumber(rs.getInt(7));
                 rechargeRecordEntity.setEquipmentName(rs.getString(8));
                 rechargeRecordEntity.setEquipmentNumber(rs.getInt(9));
                 rechargeRecordEntity.setTransactionTime(rs.getTimestamp(10));
                 rechargeRecordEntities.add(rechargeRecordEntity);
             }


        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return rechargeRecordEntities;
    }

    public RechargeRecordEntity getRechargeRecordById(int id) {
        RechargeRecordEntity rechargeRecordEntity=null;
        conn = JDBCUtil.getMysqlConn();

        String sql="select id,type,pre_money,aft_money,line,dot_name,dot_number,equipment_name,"+
                "equipment_number,transaction_time from tb_recharge_record where id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,id);
            rs=ps.executeQuery();
            while (rs.next()){
                rechargeRecordEntity=new RechargeRecordEntity(rs.getInt(1),
                        rs.getString(2),
                        rs.getDouble(3),
                        rs.getDouble(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getInt(7),
                        rs.getString(8),
                        rs.getInt(9),
                        rs.getTimestamp(10));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL 执行异常 ，请检查！");
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }


        return rechargeRecordEntity;
    }

    public boolean addRechargeRecord(int id, double money) {
        RechargeRecordEntity rechargeRecordEntity=null;
        int result=0;
        //1.加载数据库驱动
        //2.获取数据库连接
         conn = JDBCUtil.getMysqlConn();
         rechargeRecordEntity=new RechargeRecordEntity(id,"普通充值卡",00.00,money,"16号线","极客学院网点",
                 2005486,"自住充值机",15864525,new Timestamp(System.currentTimeMillis()));
         String sql="insert into tb_recharge_record(id,type,pre_money,aft_money,line,dot_name,dot_number,equipment_name,equipment_number,transaction_time) values(?,?,?,?,?,?,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,rechargeRecordEntity.getId());
            ps.setObject(2,rechargeRecordEntity.getType());
            ps.setObject(3,rechargeRecordEntity.getPreMoney());
            ps.setObject(4,rechargeRecordEntity.getAftMoney());
            ps.setObject(5,rechargeRecordEntity.getLine());
            ps.setObject(6,rechargeRecordEntity.getDotName());
            ps.setObject(7,rechargeRecordEntity.getDotNumber());
            ps.setObject(8,rechargeRecordEntity.getEquipmentName());
            ps.setObject(9,rechargeRecordEntity.getEquipmentNumber());
            ps.setObject(10,rechargeRecordEntity.getTransactionTime());
            result=ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL 执行异常 ，请检查！");
        }finally {
            JDBCUtil.close(rs,ps,conn);
        }

        return result==1?true:false;
    }

    public boolean updateRechargeRecord(RechargeRecordEntity rechargeRecordEntity, double money, boolean state) {
        int result=0;
        //1.加载数据库驱动
        //2.获取数据库连接
        conn = JDBCUtil.getMysqlConn();
        //3.更新数据库
        String sql="update tb_recharge_record set pre_money=?,aft_money=?,transaction_time=? where id=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setObject(1,rechargeRecordEntity.getAftMoney());
            //充值+money  刷卡-money
            ps.setObject(2,state==true?rechargeRecordEntity.getAftMoney()+money:rechargeRecordEntity.getAftMoney()-money);
            ps.setObject(3,new Timestamp(System.currentTimeMillis()));
            ps.setObject(4,rechargeRecordEntity.getId());
            result=ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("SQL 执行异常 ，请检查！");
        } finally {
            JDBCUtil.close(rs,ps,conn);
        }
        return result==1?true:false;
    }
}

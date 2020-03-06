package com.jike.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
    //可以帮助读取和处理资源文件中的信息
     static Properties pros=null;
    static {
        pros=new Properties();
        //            InputStream inputStream = new BufferedInputStream(new FileInputStream("./src/main/resources/database.properties"));
//            pros.load(inputStream);
//            pros.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("database.properties"));
    }

    /**
     * 建立mysql连接
     * @return
     */
    public static Connection getMysqlConn(){
        try {
            //加载驱动
//            Class.forName(pros.getProperty("mysqlDriver"));
            Class.forName("com.mysql.jdbc.Driver");
//            return DriverManager.getConnection(pros.getProperty("mysqlURL"),
//                    pros.getProperty("mysqlUser"),pros.getProperty("mysqlPwd"));
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/jk_pro_db?useUnicode=true&characterEncoding=UTF-8","root","123456");

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public static void close(ResultSet rs, Statement ps, Connection conn){
        try {
            if(rs!=null){
                rs.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(ps!=null){
                ps.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}


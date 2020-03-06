package com.jike.exam.dao;

import com.jike.exam.exception.ExamException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExamAnswerOperator {

    public List<String> readExamFile(File file){
          if(file==null || file.length()<0){
              throw new ExamException("文件名称不能为空");
          }
        List<String> content = new ArrayList<>();
        //读取文件IO流
        FileReader fr=null;
        BufferedReader br=null;
        try {
            //打开文件
            fr= new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            //读文件
            while ((line=br.readLine())!=null){
                if(!line.trim().equals("")){
                    content.add(line);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e){
            e.printStackTrace();
        }
        finally {
            //关闭文件，要求：反方向倒着关闭资源，先关闭br,在关闭fr
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return content;
    }
}

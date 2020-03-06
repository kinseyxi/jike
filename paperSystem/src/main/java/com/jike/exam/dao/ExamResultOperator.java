package com.jike.exam.dao;

import java.io.*;

public class ExamResultOperator {
    private static final File ANSWER_FILENAME =new File("./src/main/resources/answer.bat") ;

    public void saveAnswer(char[] answer){
       FileOutputStream fos=null;
       ObjectOutputStream oos=null;

        try {
            //打开文件
            fos=new FileOutputStream(ANSWER_FILENAME);
            //对象流
            oos=new ObjectOutputStream(fos);
            //写文件
            oos.writeObject(answer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            //关闭文件
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    public char[] readAnswer(){
        char[] answer=null;
        FileInputStream fis=null;
        ObjectInputStream ois=null;

        try {
            //打开文件
            fis=new FileInputStream(ANSWER_FILENAME);
            //对象流
            ois=new ObjectInputStream(fis);
            //写文件
            answer = (char[])ois.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            //关闭文件
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return answer;
    }


}

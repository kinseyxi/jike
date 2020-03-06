package com.jike.exam.domain;

import java.util.Arrays;

/**
 * 考试题目实体类，用于封装试题信息
 */
public class Item {
    //问题
    private  String question;
    //4个选项
    private  String[] options;
    //正确答案
    private  char answer;
    //构造器，
    public Item(String question,String [] options,char answer){

        this.question = question;
        this.options = options;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return question +"\n"+
                options[0]+"\n"+
                options[1]+"\n"+
                options[2]+"\n"+
                options[3]+"\n标准答案："+answer+"\n";

    }

    public char getAnswer() {
        return answer;
    }

    public String show() {
        return question +"\n"+
                options[0]+"\n"+
                options[1]+"\n"+
                options[2]+"\n"+
                options[3]+"\n";
    }
}

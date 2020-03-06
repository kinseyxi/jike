package com.jike.exam.service;

import com.jike.exam.dao.ExamAnswerOperator;
import com.jike.exam.dao.ExamResultOperator;
import com.jike.exam.domain.Item;

import java.io.File;
import java.util.List;

public class ExamServiceImpl implements IExamService {
    //试题初始化
    private ExamAnswerOperator examAnswerOperator=new ExamAnswerOperator();
    //考试结果操作
    private ExamResultOperator examResultOperator=new ExamResultOperator();
    //所有考试题目
    private Item[] items;
    private char[] answers;
    public ExamServiceImpl(){
        initExamItems();
        answers=new char[getItemsCount()];
    }

    private void initExamItems() {
        List<String> list = examAnswerOperator.readExamFile(new File("./src/main/resources/item.txt"));
         //换行标识
        int lineSeparator=6;
        items=new Item[list.size()/lineSeparator];
        for(int i=0;i<items.length;i++){
            int iteSpe=i*lineSeparator;
            String question=list.get(iteSpe);
            String[] options={
                    list.get(iteSpe+1),
                    list.get(iteSpe+2),
                    list.get(iteSpe+3),
                    list.get(iteSpe+4),
            };
            char answer=list.get(iteSpe+5).charAt(0);
            items[i]=new Item(question,options,answer);
        }
    }


    @Override
    public Item getItem(int no) {
        return items[no];
    }

    @Override
    public int getItemsCount() {
        return items.length;
    }

    @Override
    public char[] readAnswer() {
        return examResultOperator.readAnswer();
    }

    @Override
    public void saveAnswer(char[] answer) {
        examResultOperator.saveAnswer(answer);
    }

    @Override
    public String levelDesc(int score) {
        int totalScore = getItemsCount() * 10;
        return getLevel(score,totalScore);
    }

    public String getLevel(int score, int totalScore) {

        if(score<=totalScore/2){
            return "不及格";
        }
        return "及格";
    }

    @Override
    public char[] getAnswer() {
        return answers;
    }
}

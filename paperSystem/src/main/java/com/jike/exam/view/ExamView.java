package com.jike.exam.view;

import com.jike.exam.domain.Item;
import com.jike.exam.service.ExamServiceImpl;
import com.jike.exam.service.IExamService;

import java.util.Scanner;

public class ExamView {
    private IExamService itemService = new ExamServiceImpl();
    public void show(){
        System.out.println("\n 【欢迎使用在线考试系统】..........");
        System.out.println(itemService.getAnswer());
        startExam();
    }
    //开始考试
    private void startExam(){
        int curItem=1;
        //显示答案操作提示信息
        displayWelcomInfo();
        while (true){
            displayItem(curItem);
            System.out.println("请选择正确答案（p-上一题  n-下一题 f-结束考试）：");
            char key=ScannerUtil.getUserAction();
            switch (key){
                case 'A':
                case 'B':
                case 'C':
                case 'D':itemService.getAnswer()[curItem-1]=key;
                    break;

                  //显示下一题
                case 'N':if(curItem<itemService.getItemsCount()){
                    ++curItem;
                }else {
                    System.out.println("已达最后一题，下面是您此次的答案成绩");
                    itemService.saveAnswer(itemService.getAnswer());
                    reviewLastExam();
                    return;
                }
                    break;
                    //显示上一题
                case 'P':if(curItem>1){
                    --curItem;
                }else {
                    System.out.println("已经达到第一题");
                }
                    break;
                    //结束考试
                case 'F':if(endExam("确定是否考试结束（y/n）")){
                    itemService.saveAnswer(itemService.getAnswer());
                    reviewLastExam();
                    return;
                }
                    break;
                    default:
                        System.out.println("输入无效");
            }
        }
    }

    private void displayWelcomInfo() {
        int totalScore = itemService.getItemsCount() * 10;
        System.out.println("试卷共"+itemService.getItemsCount()+"题，总分："+totalScore+"分，试卷全部是单选题," +
                "请在正确地方填写你的答案A、B、C、D");
    }

    private void displayItem(int curItem) {

        String item = itemService.getItem(curItem - 1).show();
        System.out.println(item);
    }


    //查看考试成绩
    public void reviewLastExam(){
        System.out.println("\n\n");
        char[] charAnswer=itemService.readAnswer();
        /**得到所有试题的条数*/
        int score=0;
        for(int i=0;i<itemService.getItemsCount();i++){
            /**根据索引号得到单个试题*/
            Item item=itemService.getItem(i);
            //判分
            if(charAnswer[i]==item.getAnswer()){
                score+=10;
            }
        }
        //按成绩划分等级
        System.out.println("\n---------------------------------");
        System.out.println("恭喜，本次考试成绩："+score+"分，"+itemService.levelDesc(score));
        System.out.println("序 号     标准答案     你的答案 ");
        //答案详情
        for(int i=0;i<itemService.getItemsCount();i++){
            Item item=itemService.getItem(i);
            System.out.println("第"+((i<9)?" ":"")+(i+1)+"题   "
                    +item.getAnswer()+"                "+charAnswer[i]);
        }
        System.out.println("--------------------------------------");
    }
    //结束考试
    private boolean endExam(String msg){
        System.out.println("\n"+msg);
        while (true){
            char key = ScannerUtil.getUserAction();
            if(key!='N' && key!='Y'){
                continue;
            }
            return (key=='Y');
        }
    }
}

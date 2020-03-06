package com.jike.exam.service;

import com.jike.exam.domain.Item;

public interface IExamService {
    /**根据索引号得到单个试题*/
    Item getItem(int no);
    /**得到所有试题的条数*/
    int getItemsCount();
    /**读取上次试题的答案*/
    char[] readAnswer();
    /**保存答案*/
    void saveAnswer(char[] answer);
    /**得到此次答案的评价*/
    String levelDesc(int score);
    /**得到所有问题的答案*/
    char[] getAnswer();

}

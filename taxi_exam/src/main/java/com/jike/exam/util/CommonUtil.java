package com.jike.exam.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    //从字符串中取数字
    public static List<String> getNumberbyMatcher(String str){
        List<String> listNumbers= new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()){
            String strNumber = matcher.group();
            listNumbers.add(strNumber);
        }
        return listNumbers;
    }
    //将String类型转换成int
    public static int transferInt(String str){
        int number = 0;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return number;
    }

}

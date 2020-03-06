package com.jike.exam.view;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Scanner;

public class ScannerUtil {

    public final static char getUserAction(){
        char[] validKey={'1','2','3','A','B','C','D','F','N','P','Y'};
        Scanner scanner=new Scanner(System.in);
        char key=0;
        while (scanner.hasNext()){
            //接受键盘输入
            String str=scanner.next();
            if (str.length()!=1){
                continue;
            }
            //忽略大小写
            str=str.toUpperCase();
            key=str.charAt(0);
            for (char k:validKey){
                if(k==key){
                    return key;
                }
            }
        }
        return key;
    }
}

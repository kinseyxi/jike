package com.jike.xueyuan.mainenter;

import java.util.Scanner;

public class CompanyAccount {
    String details="收支\t  余额\t  金额\t  说明\n";
    boolean flag=true;
    Scanner scanner=new Scanner(System.in);
    int balance=10000;
    public static void main(String[] args) {
        CompanyAccount companyAccount = new CompanyAccount();
       companyAccount.companyConsole();
    }
    public void companyConsole(){
        char c;
        do{
            System.out.println("\n ---------企业收支软件系统------------\t");
            System.out.println("\t 1 企业登记收入");
            System.out.println("\t 2 企业登支出");
            System.out.println("\t 3 企业收支明细");
            System.out.println("\t 4 退出\n");
            System.out.println("请选择(1-4)");
            while (true){
                String str=readKeyBoard(1);
                c=str.charAt(0);
                if(c!='1' && c!='2' && c!='3'&& c!='4'){
                    System.out.println("输入字符非法，请重新输入字符（1，2，3，4）");
                }
                break;
            }
            switch (c){
                case '1':
                    income();
                    break;
                case '2':
                    pay();
                    break;
                case '3':
                    showDeatail();
                    break;
                case '4':
                    exit();
                    break;

            }
        }while (flag);


    }

    private void exit() {
        System.out.println("确定要退出吗？(Y/N)");
        while (true){
            String str = readKeyBoard(1).toUpperCase();
            char yn = str.charAt(0);
            //既不是Y 又不是N
            if(yn!='Y' && yn!='N'){
                System.out.println("请正确输入Y/N");
            }else {
                if(yn=='Y') flag=false;
                break;
            }
        }
    }

    private void showDeatail() {
        System.out.println("--------------企业收支明细--------------");
        System.out.println(details);
        System.out.println("--------------------------------------");
    }

    private void pay() {
        int money;
        System.out.println("请输入本次支出金额：");
        while (true){
            String str = readKeyBoard(3);
            try {
                money = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("输入本次支出描述");
        String  desc=readKeyBoard(5);
        balance-=money;
        details+="支出\t"+balance+"\t\t"+money+"\t\t"+desc+"\n";
        System.out.println("------------登记完成---------------------");

    }

    private void income() {
        int money;
        System.out.println("请输入本次收入金额：");
        while (true){
            String str = readKeyBoard(3);
            try {
                money = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        System.out.println("输入本次收入描述");
        String  desc=readKeyBoard(5);
        balance+=money;
        details+="收入\t"+balance+"\t\t"+money+"\t\t"+desc+"\n";
        System.out.println("------------登记完成---------------------");

    }

    private String readKeyBoard(int limit) {
        String str="";
       while (scanner.hasNext()){
           str = scanner.next();
           if(str.length()<1 || str.length()>limit){
               System.out.println("输入字符长度不能大于"+limit+"请重新输入");
               continue;
           }
           break;
       }
       return str;
    }
}

package com.jike.xueyuan.account.mainenter;

import java.util.Scanner;

public class CompanyAccount {
    boolean flag=true;
    String details="收支\t 账号金额\t 收支金额\t 说   明\n";
    int balance=10000;//运转基金
    private Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        CompanyAccount companyAccount = new CompanyAccount();
        companyAccount.commpanyConsole();
    }
    public void commpanyConsole(){
        char c;
        do {
            System.out.println("\n-----------------企业收支软件系统-------------\n");
            System.out.println("\t 1 企业登记收入");
            System.out.println("\t 2 企业登记支出");
            System.out.println("\t 3 企业收支明细");
            System.out.println("\t 4 退出");
            System.out.println("\t 请选择(1-4):");
            while (true){
                String str=readKeyBoard(1);
                c=str.charAt(0);
                if(c!='1' && c!='2' && c!='3' && c!='4'){
                    System.out.println("您输入参数有误，请重新输入：");
                }else break;
            }
            switch (c){
                case '1':
                    income();
                    break;
                case '2':
                    pay();
                    break;
                case '3':
                    detail();
                    break;
                case '4':
                    exit();
                    break;

            }
        }while (flag);
    }
    private void exit(){
        System.out.println("确定是否退出(Y/N)");
        char yn;
        for(;;){
            String str=readKeyBoard(1).toUpperCase();
            yn=str.charAt(0);
            if(yn=='Y' || yn=='N'){
                break;
            }else {
                System.out.println("您输入的参数有误，请重新输入:");
            }
            if(yn=='Y') flag=false;
        }
    }
    private void detail() {
        System.out.println("-----------------收支明细---------------");
        System.out.println(details);
        System.out.println("---------------------------------------");
    }

    private void pay() {
        System.out.println("本次支出金额："); //键盘处理
        int amount;
        for(;;){
            String str = readKeyBoard(4);
            try {
                amount = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        balance-=amount;
        System.out.println("本次支出说明：");
        String desc2=readKeyBoard(8);
        details+="支出\t"+balance+"\t\t"+amount+"\t\t"+desc2+"\n";
        System.out.println("-----------------登记完成-------------------------");
    }

    private void income() {
        System.out.println("本次收入金额："); //键盘处理
        int amount;
        for(;;){
            String str = readKeyBoard(4);
            try {
                 amount = Integer.parseInt(str);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        balance+=amount;
        System.out.println("本次收入说明：");
        String desc1=readKeyBoard(8);
        details+="收入\t"+balance+"\t\t"+amount+"\t\t"+desc1+"\n";
        System.out.println("---------------------登记完成-----------------------");
    }

    public String readKeyBoard(int limit){
        String line="";
        while (scanner.hasNext()){
             line = scanner.next();
            if(line.length()<1 || line.length()>limit){
                System.out.println("输入长度（不大于"+limit+"）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }

}


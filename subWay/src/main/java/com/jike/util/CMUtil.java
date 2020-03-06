package com.jike.util;

import javax.swing.*;
import java.util.Scanner;

public class CMUtil {
    public static char getUserAction() {
        char[] validKey = {'0', '1', '2', '3', '4'};
        char key = 0;
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if (str.length() != 1) {
                JOptionPane.showMessageDialog(null, "无法识别您的操作，请重新输入", "操作提示", JOptionPane.PLAIN_MESSAGE);
                continue;
            }
            str = str.toUpperCase();
            key = str.charAt(0);
            for (char k : validKey) {
                if (k == key) return key;
            }
        }
        return key;
    }


    public static String readString(int limit) {
        Scanner scanner = new Scanner(System.in);
        String str = "YES";
        while (scanner.hasNext()) {
            str = scanner.next();
            if (str.length()>limit) {
                JOptionPane.showMessageDialog(null, "无法识别您的操作，请重新输入", "操作提示", JOptionPane.PLAIN_MESSAGE);
                continue;
            }
            str = str.toUpperCase();
            if ("YES".equals(str) || "BYE".equals(str)) {
                return str;
            }
        }

        return str;
    }

    public static int readInt() {
        Scanner scanner = new Scanner(System.in);
        int carId = 0;
        while (scanner.hasNext()) {
            String str = scanner.next();
            try {
                carId = Integer.parseInt(str);
                return carId;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "无法识别您的操作，请重新输入", "操作提示", JOptionPane.PLAIN_MESSAGE);
                continue;
            }
        }
        return carId;
    }

    public static double readDouble() {
        Scanner scanner = new Scanner(System.in);
        double money = 0.00;
        while (scanner.hasNext()) {
            String str = scanner.next();
            try {
                money = Double.parseDouble(str);
                return money;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "无法识别您的操作，请重新输入", "操作提示", JOptionPane.PLAIN_MESSAGE);
                continue;
            }
        }
        return money;
    }

}

package com.jike.exam.util;

public class Calculator {

    public static int calculate(int kilo, int waitTime) {
        if(kilo<=2){
            return (int) Math.round(6+waitTime*0.25);
        }
        if(kilo>2 && kilo<=8){
            return (int) Math.round((6+(kilo-2)*0.8)+waitTime*0.25);
        }
        if(kilo>8){
            return (int) (10.8+(kilo-8)*1.2);
        }
      return 0;
    }
}

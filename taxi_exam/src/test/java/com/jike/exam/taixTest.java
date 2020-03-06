package com.jike.exam;

import com.jike.exam.util.Calculator;
import com.jike.exam.IO.TripInput;
import com.jike.exam.util.CommonUtil;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.util.List;


public class taixTest {
    @Test
    public void test_getNumber(){
        String str="13公里，等待0分钟\n";
        List<String> numberbyMatcher = CommonUtil.getNumberbyMatcher(str);
        Assert.assertEquals(numberbyMatcher.size(),2);
    }
    @Test
    public void test_readFile(){
        String filename="./src/main/resources/testData.txt";
        File testDataFile=new File(filename);
        TripInput ti = new TripInput();
        List<String> readFile = ti.readFile(testDataFile);
        Assert.assertEquals(readFile.size(),8);
    }
    @Test
    public void kilo_1_le2(){
        int price= Calculator.calculate(1, 0);
        Assert.assertEquals(price,6);
    }
    @Test
    public void kilo_le8(){
        int price= Calculator.calculate(3, 0);
        Assert.assertEquals(price,7);
    }
    @Test
    public void kilo_ge8(){
        int price= Calculator.calculate(10, 0);
        Assert.assertEquals(price,13);
    }
    @Test
    public void kilo_rangele2_wait_3(){
        int price= Calculator.calculate(2, 3);
        Assert.assertEquals(price,7);
    }
}

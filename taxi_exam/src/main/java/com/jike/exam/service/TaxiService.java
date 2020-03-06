package com.jike.exam.service;
import com.jike.exam.IO.TripInput;
import com.jike.exam.util.Calculator;
import com.jike.exam.util.CommonUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
public class TaxiService {
    String receipt="";
    private TripInput tripInput=new TripInput();
    List<Integer> trips=new ArrayList<>();
    public TaxiService(File testDataFile) {
        initPassenger(testDataFile);
    }
    private void initPassenger(File testDataFile) {
        List<String> strList=tripInput.readFile(testDataFile);
        for(String str:strList){
            Integer trip= Integer.valueOf(CommonUtil.transferInt(str));
            trips.add(trip);
        }
    }

    public String payment() {
        ListIterator<Integer> iterator=trips.listIterator();
        while (iterator.hasNext()){
            int waitTime = 0;
            int kilometer = iterator.next().intValue();
            if(iterator.hasNext()){
                waitTime=iterator.next().intValue();
            }
           int price= Calculator.calculate(kilometer,waitTime);
            receipt+="收费"+price+"元\n";
        }
        return receipt;
    }
}

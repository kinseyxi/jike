package com.jike.exam.IO;

import com.jike.exam.exception.TaxiException;
import com.jike.exam.util.CommonUtil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TripInput {

    public List<String> readFile(File testDataFile) {
        if(testDataFile==null || testDataFile.length()<0){
            throw new TaxiException("文件名称不能为空");
        }
        List<String> numbers=new ArrayList<>();

        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(testDataFile);
            br = new BufferedReader(fr);
            String line;
            while ((line=br.readLine())!= null) {
                if(!line.trim().equals("")){
                    List<String> matchers = CommonUtil.getNumberbyMatcher(line);
                    numbers.addAll(matchers);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return numbers;
    }
}

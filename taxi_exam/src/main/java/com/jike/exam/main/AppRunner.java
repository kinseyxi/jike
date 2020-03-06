package com.jike.exam.main;

import com.jike.exam.service.TaxiService;

import java.io.File;

public class AppRunner {
    public static void main(String[] args) {
        String filename="./src/main/resources/testData.txt";
        TaxiService passenger = new TaxiService(new File(filename));
        String recept=passenger.payment();
        System.out.println(recept);
    }
}

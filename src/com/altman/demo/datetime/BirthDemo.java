package com.altman.demo.datetime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class BirthDemo {

    private final static int DAYS = 365;

    public String getRandomBirth() {
        DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Calendar c = Calendar.getInstance();
        // only generate the ages between 14 and 40
        int days = getRandomInt(14 * DAYS, 40 * DAYS);
        c.add(Calendar.DATE, -days);
        return dateFormat.format(c.getTime());
    }

    public int getRandomInt(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public static void main(String[] args) {
        BirthDemo demo = new BirthDemo();
        System.out.println(demo.getRandomBirth());
    }

}

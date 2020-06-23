package com.utils;




import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class MyDateUtils {

    private final static String RULE = "yyyy-MM-dd HH:mm:ss";

    public static String getDateToString(Date date){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RULE);
        return simpleDateFormat.format(date);
    }

    public static Date getStringToDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(RULE);
        Date date = null;
        try {
            date =  simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}

package com.icodejava.research.nlp.utils;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtils {
    
    public static void main(String args []) {
        getCurrentDateAndTime();
    }

    public static String getCurrentDateAndTime() {
        String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Calendar c1 = Calendar.getInstance(); //now
        
        String dateTime = sdf.format(c1.getTime());
        System.out.println("Date and time is " + dateTime );
        
        return dateTime;
    }

}

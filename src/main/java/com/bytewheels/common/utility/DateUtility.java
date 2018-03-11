package com.bytewheels.common.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {

    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public static Date getDateFromString(String stringDate) {
        Date date = null;
        try {
            if (stringDate != null && !stringDate.isEmpty()) {
                date = sdf.parse(stringDate);
                Calendar cal = Calendar.getInstance();
                cal.setTime(date);
                cal.set(Calendar.HOUR_OF_DAY, 23);
                cal.set(Calendar.MINUTE, 59);
                cal.set(Calendar.SECOND, 59);
                date = cal.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getDateAsString(Date date) {
        return sdf.format(date);
    }
}

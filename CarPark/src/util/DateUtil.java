package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static Date date;

    public static Date getSystemDate() {
        if (date == null) {
            return new Date();
        }
        return date;
    }

    public static void setSystemDate(Date newDate) {
        date = newDate;
    }

    public static void setSystemDate(String newDateString) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            date = format.parse(newDateString);
        } catch (ParseException e) {
            System.out.println("parse date string error");
        }
    }
}

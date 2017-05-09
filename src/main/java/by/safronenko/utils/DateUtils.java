package by.safronenko.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class DateUtils {

    public static String invertDate(String date){
        String year = date.substring(0, 4);
        String month = date.substring(5,7);
        String day = date.substring(8);
        return day + "." + month + "." + year;
    }

    public static String currentDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyy");
        return format.format(date);
    }

    public static String reverceDate(String date){
        String year = date.substring(6);
        String month = date.substring(3,5);
        String day = date.substring(0, 2);
        return year + "-" + month+ "-" + day;
    }

    public static int dateEquals(String date) throws ParseException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyy");
        Date date1 = format.parse(date);

        Date date2 = format.parse(DateUtils.currentDate());

        if (date1.getTime() < date2.getTime()) return 0;
        else return 1;
    }

}

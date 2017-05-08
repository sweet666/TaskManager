package by.safronenko.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

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
}

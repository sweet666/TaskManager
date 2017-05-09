package by.safronenko;


import by.safronenko.utils.DateUtils;
import org.junit.Test;

import java.text.ParseException;

public class ServiceTest {



    @Test
    public void testService() throws ParseException {

        String date = "08.04.2022";

        System.out.println(DateUtils.dateEquals(date));



    }
}

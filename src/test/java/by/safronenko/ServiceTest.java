package by.safronenko;

import by.safronenko.entities.Task;
import by.safronenko.service.TaskService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class ServiceTest {



    @Test
    public void testService(){

        String date = "24.05.1989";

        String year = date.substring(6);
        String month = date.substring(3,5);
        String day = date.substring(0, 2);

        System.out.println(year + "." + month+ "." + day);


    }
}

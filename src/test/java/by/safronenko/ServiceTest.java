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

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
        System.out.println(format.format(date));


    }
}

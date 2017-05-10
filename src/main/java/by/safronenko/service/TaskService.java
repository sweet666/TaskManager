package by.safronenko.service;


import by.safronenko.entities.Task;
import org.springframework.data.jpa.repository.Query;

import java.text.ParseException;
import java.util.List;

public interface TaskService {

    List<Task> findAllTasks();

    List<Task> findCurrentTasks();

    List<Task> findFinishedTasks();

    void addTask(Task task);

    void deleteTask(int id);

    void finishTask(int id);

    Task getTask(int id);

    List<Task> findOverdueTasks() throws ParseException;

    List<Task> findTodayTasks() throws ParseException;

}

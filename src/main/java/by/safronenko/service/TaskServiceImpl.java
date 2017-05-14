package by.safronenko.service;

import by.safronenko.entities.Task;
import by.safronenko.repositories.TaskRepository;
import by.safronenko.utils.CurrentUser;
import by.safronenko.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private CurrentUser currentUser;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findCurrentTasks() {
        return taskRepository.findTasksByEnd(0, currentUser.getCurrentUser());
    }

    public List<Task> findFinishedTasks() {
        return taskRepository.findTasksByEnd(1, currentUser.getCurrentUser());
    }

    public void addTask(Task task) {
        task.setUsername(currentUser.getCurrentUser());
        taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.delete(id);
    }

    public void finishTask(int id) {
       Task task = taskRepository.findOne(id);
        task.setIs_end(1);
        taskRepository.saveAndFlush(task);
    }

    public Task getTask(int id) {
        return taskRepository.findOne(id);
    }

    public List<Task> findOverdueTasks() throws ParseException {
        List<Task> listOverdueTasks = new ArrayList<>();
        List<Task> taskList = taskRepository.findTasksByEnd(0, currentUser.getCurrentUser());
        for (Task task: taskList) {
            if (DateUtils.dateEquals(task.getExpire_date())==0){
                    listOverdueTasks.add(task);
            }
        }
        return listOverdueTasks;
    }

    public List<Task> findTodayTasks() throws ParseException {
        List<Task> listOverdueTasks = new ArrayList<>();
        List<Task> taskList = taskRepository.findTasksByEnd(0, currentUser.getCurrentUser());
        for (Task task: taskList) {
            if (Objects.equals(task.getExpire_date(), DateUtils.currentDate())){
                listOverdueTasks.add(task);
            }
        }
        return listOverdueTasks;
    }


}

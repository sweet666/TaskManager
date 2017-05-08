package by.safronenko.service;

import by.safronenko.entities.Task;
import by.safronenko.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("taskService")
@Transactional
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public List<Task> findAllTasks() {
        return taskRepository.findAll();
    }

    public List<Task> findCurrentTasks() {
        return taskRepository.findTasksByEnd(0);
    }

    public List<Task> findFinishedTasks() {
        return taskRepository.findTasksByEnd(1);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.delete(id);
    }

    @Override
    public void finishTask(int id) {
       Task task = taskRepository.findOne(id);
        task.setIs_end(1);
        taskRepository.saveAndFlush(task);
    }


}

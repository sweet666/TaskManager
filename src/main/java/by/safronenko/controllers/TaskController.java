package by.safronenko.controllers;

import by.safronenko.entities.Task;
import by.safronenko.service.TaskService;
import by.safronenko.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @RequestMapping("/")
    public String url() {
        return "redirect:/tasks";
    }

    @RequestMapping("/tasks")
    public String listTasks(Map<String, Object> map) {

        map.put("task", new Task());
        map.put("taskList", taskService.findCurrentTasks());

        return "tasks";
    }

    @RequestMapping("/tasks/finished")
    public String listFinishedTasks(Map<String, Object> map) {

        map.put("task", new Task());
        map.put("taskList", taskService.findFinishedTasks());

        return "finished";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addVote(@ModelAttribute("task") Task task) {

        task.setExpire_date(DateUtils.invertDate(task.getExpire_date()));
        task.setStart_date(DateUtils.currentDate());
        taskService.addTask(task);

        return "redirect:/tasks";
    }
}

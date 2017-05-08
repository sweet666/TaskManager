package by.safronenko.controllers;

import by.safronenko.entities.Task;
import by.safronenko.service.TaskService;
import by.safronenko.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
    public String addTask(@ModelAttribute("task") Task task) {

        task.setExpire_date(DateUtils.invertDate(task.getExpire_date()));
        task.setStart_date(DateUtils.currentDate());
        taskService.addTask(task);

        return "redirect:/tasks";
    }

    @RequestMapping(value = "/delete/{taskId}")
    public String deleteTask(@PathVariable("taskId") int taskId) {

        taskService.deleteTask(taskId);

        return "redirect:/tasks";
    }

    @RequestMapping(value = "/end/{taskId}")
    public String finishTask(@PathVariable("taskId") int taskId) {

        taskService.finishTask(taskId);

        return "redirect:/tasks";
    }

    @RequestMapping(value = "/get/{taskId}")
    public ModelAndView main(@PathVariable("taskId") int taskId) {
        ModelAndView modelAndView = new ModelAndView();
        Task task = taskService.getTask(taskId);
        task.setExpire_date(DateUtils.reverceDate(task.getExpire_date()));
        modelAndView.addObject("task", task);
        modelAndView.setViewName("edit");
        return modelAndView;
    }

    @RequestMapping(value = "/get/update/{taskId}", method = RequestMethod.POST)
    public String updateTask(@ModelAttribute("task") Task task, @PathVariable("taskId") int taskId) {

        task.setId(taskId);
        task.setExpire_date(DateUtils.invertDate(task.getExpire_date()));
        task.setStart_date(DateUtils.currentDate());
        taskService.addTask(task);

        return "redirect:/tasks";
    }
}

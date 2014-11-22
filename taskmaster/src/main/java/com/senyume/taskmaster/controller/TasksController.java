package com.senyume.taskmaster.controller;

import com.senyume.taskmaster.domain.Task;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

/**
 * @author jigish
 */

@Controller
public class TasksController {

    private static Logger logger = Logger.getLogger(TasksController.class);

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private Validator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(this.validator);
    }

    @RequestMapping(value="/tasks", method= RequestMethod.GET)
    public @ResponseBody
    List<Task> listTasks(Locale locale){

        List<Task> taskList = new ArrayList<Task>();

        // make up fake data to return
        Task task1 = new Task();
        task1.setName("pick up mail");
        task1.setCategory("weekly");
        task1.setDue(new GregorianCalendar(2014,1,28,15,0,0));
        taskList.add(task1);

        Task task2 = new Task();
        task2.setName("pay bills");
        task2.setCategory("monthly");
        task2.setDue(new GregorianCalendar(2014,5,29,18,0,0));
        taskList.add(task2);

        Task task3 = new Task();
        task3.setName("pick up groceries");
        task3.setCategory("weekly");
        task3.setDue(new GregorianCalendar());

        return taskList;
    }

    // note the @RequestBody annotation in createTask method declaration since this method will handle HTTP POST
    // we expect the request body to contain the fields for Task object that we want to create
    @RequestMapping(value = "/tasks", method = RequestMethod.POST)
    public @ResponseBody Task createTask(@RequestBody @Valid TasksCommand tasksCommand){

        Task task = new Task();
        task.setName(tasksCommand.getName());
        task.setDue(tasksCommand.getDue());
        task.setCategory(tasksCommand.getCategory());

        return task;
    }
}

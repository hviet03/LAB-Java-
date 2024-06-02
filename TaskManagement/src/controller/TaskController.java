/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bo.TaskInputer;
import bo.TaskManager;
import java.util.ArrayList;
import model.Task;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class TaskController {

    private TaskManager taskManager;
    private TaskInputer taskInputer;

    public TaskController() {
        taskManager = new TaskManager();
    }

    //Add the task
    public void addTask() throws Exception {
        taskInputer = new TaskInputer();
        taskManager.addTask(taskInputer.getTaskInfo());
    }

    //Delete the task by id
    public Task deleteTask() throws Exception {
        int id = Validation.getInt("Enter id of task you want to delete: ", 1, Integer.MAX_VALUE);
        return taskManager.deleteTask(id);
    }

    //display list sorted in ascending order by id
    public void displayList() throws Exception {
        ArrayList<Task> ret = taskManager.getList();
        System.out.println(Task.getStringFormat());
        for (Task t : ret) {
            System.out.print(t);
        }
    }

}

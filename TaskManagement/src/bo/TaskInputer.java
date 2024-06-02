/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import model.Task;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class TaskInputer {

    private Task t;
    
    public TaskInputer() {
        t = new Task();
    }
    
    private Task getTask() {
        return t;
    }

    public Task getTaskInfo() {
        t.setName(Validation.getStringByRegex("Requirement Name: ", "Enter character format only!", "[a-zA-Z ]+"));
        t.setTask(Task.taskType.getTaskByInt(Validation.getInt("Task type (1~Code, 2~Test, 3~Design, 4~Review): ", 1, 4)));
        t.setDate(Validation.getDate("Date (dd-MM-yyyy): ", "dd-MM-yyyy", "[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}"));
        //task time is around 8 - 17h30 so start time should be 8 and limit to 17 because the min duration between start time and end time is 30 minutes ( 17h30 - 30 = 17 )
        t.setPlanFrom(Validation.getDouble("From: ", "Enter number only!", "Please enter start time in range (8 - 17)", 10.0 , 8, 17));
        //end time must be limited to [ (startime + 30-minute duration) to 17h30 ] 
        t.setPlanTo(Validation.getDouble("To: ", "Enter number only!", "Please enter end time in range (" + (t.getPlanFrom() + 0.5) + " - 17.5)", 10.0 , t.getPlanFrom() + 0.5, 17.5));
        t.setAssignee(Validation.getNonEmptyString("Assignee: "));
        t.setReviewer(Validation.getNonEmptyString("Reviewer: "));
        return t;
    }
}

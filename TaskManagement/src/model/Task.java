/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Admin
 */
public class Task {

    //TaskTypeID, Requirement Name, Date, From, Plan To Plan, Assignee, Expert
    public static final String FORMAT = "%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n";

    public Task() {
    }

    public enum taskType {
        Code, Test, Design, Review;

        public int getInt() {
            switch (this) {
                case Code:
                    return 1;
                case Test:
                    return 2;
                case Design:
                    return 3;
                case Review:
                    return 4;
            }
            throw new IndexOutOfBoundsException("Invalid value!");
        }

        public static taskType getTaskByInt(int type) {
            switch (type) {
                case 1:
                    return Code;
                case 2:
                    return Test;
                case 3:
                    return Design;
                case 4:
                    return Review;
            }
            throw new IndexOutOfBoundsException("Invalid value!");
        }
    }

    private taskType task;
    private int id;
    private String name, date, assignee, reviewer;
    private double planFrom, planTo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public taskType getTask() {
        return task;
    }

    public void setTask(taskType task) {
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAssignee() {
        return assignee;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public double getPlanFrom() {
        return planFrom;
    }

    public void setPlanFrom(double planFrom) {
        this.planFrom = planFrom;
    }

    public double getPlanTo() {
        return planTo;
    }

    public void setPlanTo(double planTo) {
        this.planTo = planTo;
    }
  
    public String getTime() {
        return planFrom + " - " +  planTo;
    }

    @Override
    public String toString() {
        return String.format(FORMAT, id, name, task, date, getTime(), assignee, reviewer); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static String getStringFormat() {
        return String.format(FORMAT, "ID", "Name", "Task Type", "Date", "Time", "Assignee", "Reviewer");
    }

}

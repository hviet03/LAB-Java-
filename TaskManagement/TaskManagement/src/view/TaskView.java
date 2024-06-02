package view;

import common.InOutUtils;
import java.util.ArrayList;
import model.Task;

/**
 *
 * @author admin
 */
public class TaskView {

    private InOutUtils valid = new InOutUtils();

    public void displayMenu() {
        System.out.println("\n======= Task program ======\n"
                + "1.Add Task\n"
                + "2.Delete Task\n"
                + "3.Display Task\n"
                + "4.Exit\n"
                + "Your choice:");
    }

    public Task addTask(int id) {
        Task task = new Task();
        System.out.println("-------- Add Task--------");
        task.setId(id);
        task.setName(valid.getNonEmptyString("Required name: "));
        task.setTaskType(task.getTypeTask(inputTypeTask("Enter task type: ")));
        task.setDate(valid.getDate("Date (dd-MM-yyyy): ", "dd-MM-yyyy", "[0-9]{1,2}-[0-9]{1,2}-[0-9]{4}"));
        task.setPlanFrom(valid.getDouble("From: ", "Enter number only!", "Please enter start time in range (8 - 17)", 10.0, 8, 17));
        task.setPlanTo(valid.getDouble("To: ", "Enter number only!", "Please enter end time in range (" + (task.getPlanFrom() + 0.5) + " - 17.5)", 10.0, task.getPlanFrom() + 0.5, 17.5));
        task.setAssignee(valid.getNonEmptyString("Assignee: "));
        task.setReviewer(valid.getNonEmptyString("Reviewer: "));
        return task;
    }

    public void displayTask(ArrayList<Task> taskList) {
        if (taskList.isEmpty()) {
            System.err.println("List is empty!");
            return;
        }
        System.out.printf("%-7s%-20s%-20s%-20s%-20s%-20s%-20s\n", "ID", "Name", "Task Type", "Date", "Time", "Assginee", "Reviewer");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.printf("%-7d%-20s%-20s%-20s%-20s%-20s%-20s\n", taskList.get(i).getId(), taskList.get(i).getName(),
                    taskList.get(i).getTaskType(), taskList.get(i).getDate(), taskList.get(i).getTime(), taskList.get(i).getAssignee(), taskList.get(i).getReviewer());
        }
    }

    public void deleteTask(int idExisted) {
        if (idExisted == -1) {
            System.err.println("Delete an task fail!");
        }
    }
    
    public int inputTypeTask(String msg) {
        Task task = new Task();
        for (int i = 0; i < 4; i++) {
            System.out.println((i + 1) + "." + task.typeTask[i]);
        }
        while (true) {
            return valid.getInt(msg, 1, 4);
        }
    }

}

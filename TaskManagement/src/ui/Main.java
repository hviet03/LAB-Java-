/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.TaskController;
import model.Task;
import utils.Validation;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        TaskController taskController = new TaskController();
        String menu = "\n======= Task program ======\n"
                + "1.Add Task\n"
                + "2.Delete Task\n"
                + "3.Display Task\n"
                + "4.Exit\n";
        int choice;
        do {
            choice = Validation.getInt(menu + "Enter your choice: ", 1, 4);
            try {
                switch (choice) {
                    case 1: //Add the task
                        taskController.addTask();
                        System.out.println("Added successfully!\n");
                        break;
                    case 2: //Delete the task by id
                        Task deletedTask = taskController.deleteTask();
                        System.out.println("Deleted successfully!\n");
                        System.out.println(Task.getStringFormat());
                        System.out.println(deletedTask);
                        break;
                    case 3: //Display the task that sorted in ascending order by id
                        taskController.displayList();
                        break;
                    case 4:
                        System.out.println("Program Ended!");
                        break;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage() + "\n");
            }
        } while (choice != 4);
    }

}

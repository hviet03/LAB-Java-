package main;

import controller.TaskManager;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TaskManager taskController = new TaskManager();
        taskController.displayMenu();
    }

}

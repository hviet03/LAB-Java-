package controller;

import common.InOutUtils;
import model.Task;
import java.util.ArrayList;
import view.TaskView;

public class TaskManager {

    private TaskView view = new TaskView();
    private InOutUtils input = new InOutUtils();
    private int lastId = 0;
    private ArrayList<Task> taskList = new ArrayList<>();

    public void displayMenu() {
        while (true) {
            view.displayMenu();
            int choice = input.inputIntInRange(1, 4);
            switch (choice) {
                case 1:

                    addTask(++lastId);
                    break;

                case 2:
                    deleteTask();
                    break;

                case 3:
                    view.displayTask(taskList);
                    break;

                case 4:
                    return;

            }
        }
    }

    private void addTask(int id) {
        taskList.add(view.addTask(id));
    }
    
    private void deleteTask() {
        int id = input.getInt("Enter ID: ", 1, Integer.MAX_VALUE);
        int idExisted = input.checkIdExisted(taskList, id);
        if (idExisted != -1) {
            taskList.remove(idExisted);
        }
        view.deleteTask(idExisted);
    }

}

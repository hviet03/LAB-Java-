/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo;

import java.util.ArrayList;
import model.Task;

public class TaskManager {

    private int lastId;
    private ArrayList<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
        lastId = 0;
    }

    //addTask
    public void addTask(Task t) throws Exception {
        t.setId(++lastId);
        taskList.add(t);
    }

    //deleteTask by id
    public Task deleteTask(int id) throws Exception {
        int index = searchById(id);
        if (index == -1) {
            throw new Exception("Not found!");
        }
        return taskList.remove(index);
    }

    private int searchById(int id) {
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    //get list sorted in ascending order by id
    public ArrayList<Task> getList() throws Exception {
        if (taskList.isEmpty()) {
            throw new Exception("List is empty!");
        }
        return taskList;
    }

}

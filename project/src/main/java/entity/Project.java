package main.java.entity;
import main.java.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Project {
    private String name;
    private final int id;
    private Map<Integer, Task> tasks; // tasks has {task1 id : task1, task2 id : task2...}
    private boolean archived;
    public Project(String name, int id){
        this.name = name;
        this.id = id;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
    }

    public ArrayList<Task> getTaskList(){
        ArrayList<Task> temp = new ArrayList<Task>();
        for (Task task: tasks.values()){
            temp.add(task);
        }
        return temp;
    }
}

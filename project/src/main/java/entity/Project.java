package main.java.entity;

import main.java.entity.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Project {
    private String name;
    private long id;
    public Map<Integer, Task> tasks; // tasks has {task1 id : task1, task2 id : task2...}
    private boolean archived;

    public Project(String name) {
        this.name = name;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
    }

    public Project(String name, long id) {

        this.name = name;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
        this.id = id;
    }

    public Project(String name, long id, Map<Integer, Task> tasks, boolean archived) {
        this.name = name;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
        this.id = id;
        this.tasks = tasks;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getArchived() {
        return this.archived;
    }

    public void setArchived(boolean state) {
        this.archived = state;
    }

    public String getName(){
        return name;
    }
    public ArrayList<Task> getTaskList(){
        ArrayList<Task> temp = new ArrayList<Task>();
        for (Task task: tasks.values()){
            temp.add(task);
        }
        return temp;
    }
    
    public void addTask(Task task){
        tasks.put(task.getId(), task);
    }
}

package entity;

import java.util.HashMap;
import java.util.Map;

public class Project {
    private String name;
    private int id;
    public Map<Integer, Task> tasks; // tasks has {task1 id : task1, task2 id : task2...}
    private boolean archived;

    public Project(String name) {
        this.name = name;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
    }

    public Project(String name, int id) {
        this.name = name;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
        this.id = id;
    }

    public Project(String name, int id, Map<Integer, Task> tasks, boolean archived) {
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

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getArchived() {
        return this.archived;
    }

    public void setArchived(boolean state) {
        this.archived = state;
    }
}

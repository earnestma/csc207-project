package main.java.entity;
import java.util.HashMap;
import java.util.Map;


public class Project {
    private String name;
    private final int id;
    private Map tasks; // tasks has {task1 id : task1, task2 id : task2...}
    private boolean archived;
    public Project(String name, int id){
        this.name = name;
        this.id = id;
        this.tasks = new HashMap<Integer, Task>();
        this.archived = false;
    }
}

package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import entity.Reminder;

public class Task {
    private String name;
    private Long id;
    private boolean hasDueDate;
    private LocalDateTime dueDate;
    private int priority; // Todoist: 1 (highest) - 4 (least, default). API does it in reverse
    private boolean completed;
    public List<Reminder> reminders; // Stores a list of reminders, with the most
                                     // urgent at the front?

    public Task(String name, int priority) {
        this.name = name;
        this.hasDueDate = false;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
        this.priority = priority;
    }

    public Task(String name, int priority, Long id) {
        this.name = name;
        this.id = id;
        this.hasDueDate = false;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
        this.priority = priority;
    }

    public Task(String name, int priority, LocalDateTime dueDate) {
        this.name = name;
        this.hasDueDate = true;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
        this.priority = priority;
    }

    public Task(String name, int priority, LocalDateTime dueDate, Long id) {
        this.name = name;
        this.id = id;
        this.hasDueDate = true;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
        this.priority = priority;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long id) {
        this.id = id;
    }

    public boolean hasDueDate() {
        return this.hasDueDate;
    }

    public LocalDateTime getDueDate() {
        // check using hasDueDate() first
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.hasDueDate = true; // always set to true if run
        this.dueDate = dueDate;
    }

    public void removeDueDate() {
        this.hasDueDate = false;
        this.dueDate = null;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted() {
        this.completed = true;
    }
}

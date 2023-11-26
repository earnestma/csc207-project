package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private int id;
    private boolean hasDueDate;
    private LocalDateTime dueDate;
    private int priority; // Todoist: 1 (highest) - 4 (least, default)
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

    public Task(String name, int priority, int id) {
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
        this.priority = 4; // default/least value
    }

    public Task(String name, int priority, LocalDateTime dueDate, int id) {
        this.name = name;
        this.id = id;
        this.hasDueDate = true;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
        this.priority = 4; // default/least value
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setCompleted(boolean state) {
        this.completed = true;
    }
}

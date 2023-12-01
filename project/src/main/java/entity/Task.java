package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private Long id;
    private boolean hasDueDate;
    private LocalDateTime dueDate;
    private boolean completed;
    public List<Reminder> reminders; // Stores a list of reminders, with the most
                                     // urgent at the front?

    public Task(String name) {
        this.name = name;
        this.hasDueDate = false;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }

    public Task(String name, Long id) {
        this.name = name;
        this.id = id;
        this.hasDueDate = false;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }

    public Task(String name, LocalDateTime dueDate) {
        this.name = name;
        this.hasDueDate = true;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }

    public Task(String name, LocalDateTime dueDate, Long id) {
        this.name = name;
        this.id = id;
        this.hasDueDate = true;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }

    public String getName() {
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

    public boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted() {
        this.completed = true;
    }
    
    public void markAsCompleted() {
        this.completed = true;
    }
}

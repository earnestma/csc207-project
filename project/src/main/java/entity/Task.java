package main.java.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String description;
    private final int id;
    private LocalDateTime dueDateTime;
    private int priority; // Lower value = High priority
    private boolean completed;
    private List<Reminder> reminders; // Stores a list of reminders, with the most
                                     // urgent at the front?

    public Task(String name, String description, int id, LocalDateTime dueDateTime,
                int priority){
        this.name = name;
        this.description = description;
        this.id = id;
        this.dueDateTime = dueDateTime;
        this.priority = priority;

        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }
}

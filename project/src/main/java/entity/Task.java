package project.src.main.java.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Task {
    private String name;
    private String dueDate;
    private int priority; // Lower value = High priority
    private boolean completed;
    private List<Reminder> reminders; // Stores a list of reminders, with the most
                                     // urgent at the front?

    public Task(String name, String dueDate){
        this.name = name;
        this.dueDate = dueDate;
        this.completed = false;
        this.reminders = new ArrayList<Reminder>();
    }

    public String getName() {
        return name;
    }

    public String getDueDate() {
        return dueDate;
    }
}

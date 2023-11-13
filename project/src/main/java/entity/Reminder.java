package main.java.entity;

import java.time.LocalDateTime;

public class Reminder {
    private String name;
    private String description;
    private LocalDateTime remindDateTime;

    public Reminder(String name, String description, LocalDateTime remindTime){
        this.name = name;
        this.description = description;
        this.remindDateTime = remindTime;
    }
}

package entity;

import java.time.LocalDateTime;

public class TaskFactory {
    public Task create(String taskName, LocalDateTime dueDate) {
        return new Task(taskName, dueDate);
    }
}

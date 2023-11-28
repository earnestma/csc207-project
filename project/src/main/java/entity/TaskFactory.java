package entity;

import java.time.LocalDateTime;

public class TaskFactory {
    public Task create(String taskName, int priority, LocalDateTime dueDate) {
        return new Task(taskName, priority, dueDate);
    }
}

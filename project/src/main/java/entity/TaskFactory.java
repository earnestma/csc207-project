package entity;

import java.time.LocalDateTime;

public class TaskFactory {
    public Task create(String taskName, LocalDateTime dueDate) {
        dueDate = dueDate.plusHours(23).plusMinutes(59);
        return new Task(taskName, dueDate);
    }
}

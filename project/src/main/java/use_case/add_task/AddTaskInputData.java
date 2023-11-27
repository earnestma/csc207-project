package use_case.add_task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTaskInputData {

    final private String taskName;
    final private int priority;
    final private LocalDateTime dueDate;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public AddTaskInputData(String taskName, String priority, String dueDate) {
        this.taskName = taskName;
        this.priority = Integer.parseInt(priority);
        this.dueDate = LocalDateTime.parse(dueDate, formatter);
    }

    String getTaskName() {
        return taskName;
    }

    int getPriority() {
        return priority;
    }

    LocalDateTime getDueDate() {
        return dueDate;
    }
}

package use_case.add_task;

import entity.Project;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AddTaskInputData {

    final private String taskName;
    final private int priority;
    final private LocalDateTime dueDate;
    final private Project project;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    public AddTaskInputData(String taskName, String priority, String dueDate, Project project) {
        this.taskName = taskName;
        this.priority = Integer.parseInt(priority);

        LocalDate date = LocalDate.parse(dueDate, dateFormatter);
        this.dueDate = date.atStartOfDay();
        this.project = project;
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

    Project getProject() {
        return project;
    }
}

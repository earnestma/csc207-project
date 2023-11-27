package use_case.add_task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTaskOutputData {
    private final String taskName;
    private final String dueDate;
    private boolean useCaseFailed;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AddTaskOutputData(String taskName, LocalDateTime dueDate, boolean useCaseFailed) {
        this.taskName = taskName;
        this.dueDate = dueDate.format(formatter);
        this.useCaseFailed = useCaseFailed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }
}

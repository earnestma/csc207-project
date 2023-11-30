package use_case.add_task;

import entity.Task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AddTaskOutputData {
    private final String taskName;
    private final String dueDate;
    private final ArrayList<Task> taskList;
    private boolean useCaseFailed;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public AddTaskOutputData(String taskName, LocalDateTime dueDate, ArrayList<Task> taskList, boolean useCaseFailed) {
        this.taskName = taskName;
        this.dueDate = dueDate.format(formatter);
        this.taskList = taskList;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }
    public ArrayList<Task> getTaskList(){return this.taskList;}
}

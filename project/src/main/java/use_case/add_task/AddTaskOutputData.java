package project.src.main.java.use_case.add_task;

public class AddTaskOutputData {
    private final String taskName;
    private final String dueDate;
    private boolean useCaseFailed;

    public AddTaskOutputData(String taskName, String dueDate, boolean useCaseFailed) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.useCaseFailed = useCaseFailed;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }
}

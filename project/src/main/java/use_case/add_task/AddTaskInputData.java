package project.src.main.java.use_case.add_task;

public class AddTaskInputData {

    final private String taskName;
    final private String dueDate;

    public AddTaskInputData(String taskName, String dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
    }

    String getTaskName() {
        return taskName;
    }

    String getDueDate() {
        return dueDate;
    }
}

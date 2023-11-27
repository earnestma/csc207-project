package interface_adapter.add_task;

import java.util.ArrayList;

public class AddTaskState {
    private String taskName = "";
    private String taskNameError = null;
    private String dueDate = "";
    private String dueDateError = null;

    public AddTaskState(AddTaskState copy) {
        taskName = copy.taskName;
        taskNameError = copy.taskNameError;
        dueDate = copy.dueDate;
        dueDateError = copy.dueDateError;
    }

    public AddTaskState() {}

    public String getTaskName() {
        return taskName;
    }

    public String getTaskNameError(){
        return taskNameError;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueDateError() {
        return dueDateError;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskNameError(String taskNameError) {
        this.taskNameError = taskNameError;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setDueDateError(String dueDateError) {
        this.dueDateError = dueDateError;
    }

    public ArrayList<String> showTaskAdded() {
        ArrayList<String> task = new ArrayList<String>();
        task.add(taskName);
        task.add(dueDate);
        return task;
    }
}

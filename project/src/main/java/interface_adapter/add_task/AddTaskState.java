package interface_adapter.add_task;

import entity.Project;

public class AddTaskState {
    private String taskName = "";
    private String taskNameError = null;
    private String dueDate = "";
    private String dueDateError = null;
    private Project project;

    public AddTaskState(AddTaskState copy) {
        taskName = copy.taskName;
        taskNameError = copy.taskNameError;

        dueDate = copy.dueDate;
        dueDateError = copy.dueDateError;

        project = copy.project;
    }

    public AddTaskState() {
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskNameError() {
        return taskNameError;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueDateError() {
        return dueDateError;
    }

    public Project getProject() {
        return project;
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

    public void setProject(Project project) {
        this.project = project;
    }

}

package interface_adapter.add_task;

import entity.Project;

import java.util.ArrayList;

public class AddTaskState {
    private String taskName = "";
    private String taskNameError = null;
    private String priority = "";
    private String priorityError = null;
    private String dueDate = "";
    private String dueDateError = null;
    private Project project;


    public AddTaskState(AddTaskState copy) {
        taskName = copy.taskName;
        taskNameError = copy.taskNameError;

        priority = copy.priority;
        priorityError = copy.priorityError;

        dueDate = copy.dueDate;
        dueDateError = copy.dueDateError;

        project = copy.project;
    }

    public AddTaskState() {}

    public String getTaskName() {
        return taskName;
    }

    public String getTaskNameError(){
        return taskNameError;
    }

    public String getPriority() {
        return priority;
    }

    public String getPriorityError() {
        return priorityError;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueDateError() {
        return dueDateError;
    }

    public Project getProject() {
        return new Project("hi");
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

    public ArrayList<Object> showTaskAdded() {
        ArrayList<Object> task = new ArrayList<Object>();
        task.add(taskName);
        task.add(priority);
        task.add(dueDate);
        return task;
    }

}

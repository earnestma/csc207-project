package use_case.add_task;

import entity.Project;

public class AddTaskInputData {

    final private String taskName;
    final private String dueDate;
    final private Project project;

    public AddTaskInputData(String taskName, String dueDate, Project project) {
        this.taskName = taskName;

        this.dueDate = dueDate;
        this.project = project;
    }

    String getTaskName() {
        return taskName;
    }

    String getDueDate() {
        return dueDate;
    }

    Project getProject() {
        return project;
    }
}

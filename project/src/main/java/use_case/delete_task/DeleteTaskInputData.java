package use_case.delete_task;

import entity.Project;

public class DeleteTaskInputData {
    final private String taskName;
    final private Project project;

    public DeleteTaskInputData(String taskName, Project project) {
        this.taskName = taskName;
        this.project = project;
    }

    String getTaskName() {
        return taskName;
    }

    Project getProject() {
        return project;
    }
}

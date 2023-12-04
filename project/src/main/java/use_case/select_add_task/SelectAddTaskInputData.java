package use_case.select_add_task;

import entity.Project;

public class SelectAddTaskInputData {
    final private Project project;

    public SelectAddTaskInputData(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}

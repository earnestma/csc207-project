package use_case.select_add_task;

import entity.Project;

public class SelectAddTaskOutputData {
    private final Project project;

    public SelectAddTaskOutputData(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}

package use_case.select_delete_task;

import entity.Project;

public class SelectDeleteTaskOutputData {
    private final Project project;

    public SelectDeleteTaskOutputData(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }
}

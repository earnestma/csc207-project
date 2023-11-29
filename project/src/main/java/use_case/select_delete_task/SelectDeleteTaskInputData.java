package use_case.select_delete_task;

import entity.Project;

public class SelectDeleteTaskInputData {
    final private Project project;
    public SelectDeleteTaskInputData(Project project) {
        this.project = project;
    }

    public Project getProject(){
        return project;
    }
}

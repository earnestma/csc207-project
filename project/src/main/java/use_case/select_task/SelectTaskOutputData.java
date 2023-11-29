package use_case.select_task;

import entity.Project;
import entity.Task;

public class SelectTaskOutputData {
    private final Task task;
    private final Project project;
    
    public SelectTaskOutputData(Task task, Project project){
        this.task = task;
        this.project = project;
    }
    
    public Task getTask(){return task;}
    public Project getProject(){return project;}
}

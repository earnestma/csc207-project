package use_case.select_task;

import entity.Project;
import entity.Task;

public class SelectTaskInputData {
    final private Task task;
    final private Project project;
  
    public SelectTaskInputData(Task task, Project project) {
        this.task = task;
        this.project = project;
    }
    
    public Task getTask() {return task;}
    public Project getProject() {return project;}
}

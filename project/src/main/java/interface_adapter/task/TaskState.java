package interface_adapter.task;

import entity.Project;
import entity.Task;
public class TaskState {
    private Task task;
    private Project previousProject;
    
    public TaskState(TaskState copy) {
        task = copy.task;
        previousProject = copy.previousProject;
    }
    
    // Because of the previous copy constructor, the default constructor must be explicit.
    public TaskState() {
    }
    public Task getTask() {
        return task;
    }
    
    public void setTask(Task task) {
        this.task = task;
    }
    
    public Project getPreviousProject(){return previousProject;}
    public void setPreviousProject(Project project){this.previousProject = project;}
}

package interface_adapter.task;

import entity.Task;
public class TaskState {
    private Task task;
    
    public TaskState(TaskState copy) {
        task = copy.task;
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
}

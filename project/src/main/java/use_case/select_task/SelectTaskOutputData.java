package use_case.select_task;

import entity.Task;

public class SelectTaskOutputData {
    private final Task task;
    
    public SelectTaskOutputData(Task task){
        this.task = task;
    }
    
    public Task getTask(){return task;}
}

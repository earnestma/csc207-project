package use_case.select_task;

import entity.Task;

public class SelectTaskInputData {
    final private Task task;
    
    public SelectTaskInputData(Task task){
        this.task = task;
    }
    
    public Task getTask(){return task;}
}

package interface_adapter.select_task;

import entity.Task;
import use_case.select_task.SelectTaskInputBoundary;
import use_case.select_task.SelectTaskInputData;

public class SelectTaskController {
    final SelectTaskInputBoundary selectTaskInteractor;
    
    public SelectTaskController(SelectTaskInputBoundary selectTaskInteractor){
        this.selectTaskInteractor = selectTaskInteractor;
    }
    
    public void execute(Task task){
        SelectTaskInputData selectTaskInputData = new SelectTaskInputData(task);
        
        selectTaskInteractor.execute(selectTaskInputData);
    }
    
}

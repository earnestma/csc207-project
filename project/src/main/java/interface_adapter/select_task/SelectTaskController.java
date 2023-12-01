package interface_adapter.select_task;

import entity.Project;
import entity.Task;
import use_case.select_task.SelectTaskInputBoundary;
import use_case.select_task.SelectTaskInputData;

public class SelectTaskController {
    final SelectTaskInputBoundary selectTaskInteractor;
    
    public SelectTaskController(SelectTaskInputBoundary selectTaskInteractor) {
        this.selectTaskInteractor = selectTaskInteractor;
    }
    
    public void execute(Task task, Project project) {
        SelectTaskInputData selectTaskInputData = new SelectTaskInputData(task, project);
        
        selectTaskInteractor.execute(selectTaskInputData);
    }
    
}

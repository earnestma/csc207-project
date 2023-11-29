package interface_adapter.select_delete_Task;

import entity.Project;
import use_case.select_delete_task.SelectDeleteTaskInputBoundary;
import use_case.select_delete_task.SelectDeleteTaskInputData;

public class SelectDeleteTaskController {
    final SelectDeleteTaskInputBoundary selectDeleteTaskInteractor;

    public SelectDeleteTaskController(SelectDeleteTaskInputBoundary selectDeleteTaskInteractor) {
        this.selectDeleteTaskInteractor = selectDeleteTaskInteractor;
    }

    public void execute(Project project) {
        SelectDeleteTaskInputData selectDeleteTaskInputData = new SelectDeleteTaskInputData(project);

        selectDeleteTaskInteractor.execute(selectDeleteTaskInputData);
    }
}

package interface_adapter.select_add_task;

import entity.Project;
import use_case.select_add_task.SelectAddTaskInputBoundary;
import use_case.select_add_task.SelectAddTaskInputData;

public class SelectAddTaskController {
    final SelectAddTaskInputBoundary selectAddTaskInteractor;

    public SelectAddTaskController(SelectAddTaskInputBoundary selectAddTaskInteractor) {
        this.selectAddTaskInteractor = selectAddTaskInteractor;
    }

    public void execute(Project project) {
        SelectAddTaskInputData selectAddTaskInputData = new SelectAddTaskInputData(project);

        selectAddTaskInteractor.execute(selectAddTaskInputData);
    }
}

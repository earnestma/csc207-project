package interface_adapter.delete_task;

import entity.Project;
import use_case.delete_task.DeleteTaskInputBoundary;
import use_case.delete_task.DeleteTaskInputData;

public class DeleteTaskController {

    final DeleteTaskInputBoundary deleteTaskUseCaseInteractor;

    public DeleteTaskController(DeleteTaskInputBoundary deleteTaskUseCaseInteractor) {
        this.deleteTaskUseCaseInteractor = deleteTaskUseCaseInteractor;
    }

    public void execute(String taskName, Project project) {
        DeleteTaskInputData deleteTaskInputData = new DeleteTaskInputData(taskName, project);

        deleteTaskUseCaseInteractor.execute(deleteTaskInputData);
    }
}

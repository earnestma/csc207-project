package interface_adapter.delete_project;

import entity.User;
import use_case.delete_project.DeleteProjectInputBoundary;
import use_case.delete_project.DeleteProjectInputData;

public class DeleteProjectController {

    final DeleteProjectInputBoundary deleteProjectUseCaseInteractor;
    public DeleteProjectController(DeleteProjectInputBoundary deleteProjectUseCaseInteractor) {
        this.deleteProjectUseCaseInteractor = deleteProjectUseCaseInteractor;
    }

    public void execute(String projectName, User user) {
        DeleteProjectInputData deleteProjectInputData = new DeleteProjectInputData(projectName, user);

        deleteProjectUseCaseInteractor.execute(deleteProjectInputData);
    }
}

package interface_adapter.add_project;

import use_case.add_project.*;

public class AddProjectController {
    final AddProjectInputBoundary addProjectUseCaseInteractor;

    public AddProjectController(AddProjectInputBoundary addProjectUseCaseInteractor) {
        this.addProjectUseCaseInteractor = addProjectUseCaseInteractor;
    }

    public void execute(String projectName) {
        AddProjectInputData addProjectInputData = new AddProjectInputData(projectName);

        addProjectUseCaseInteractor.execute(addProjectInputData);
    }
}

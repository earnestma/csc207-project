package interface_adapter.add_project;

import use_case.add_project.AddProjectInputData;
import use_case.add_project.AddProjectInputBoundary;

public class AddProjectController {
    final AddProjectInputBoundary addProjectUseCaseInteractor;

    public AddProjectController(AddProjectInputBoundary addProjectUseCaseInteractor) {
        this.addProjectUseCaseInteractor = addProjectUseCaseInteractor;
    }

    public void execute(String taskName, String dueDate) {
        AddProjectInputData addProjectInputData = new AddProjectInputData(taskName);

        addProjectUseCaseInteractor.execute(addProjectInputData);
    }
}

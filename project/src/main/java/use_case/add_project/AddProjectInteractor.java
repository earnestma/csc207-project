package use_case.add_project;

import entity.Project;
import entity.ProjectFactory;

public class AddProjectInteractor implements AddProjectInputBoundary {
    final AddProjectDataAccessInterface userDataAccessObject;
    final AddProjectOutputBoundary addProjectPresenter;
    final ProjectFactory projectFactory;

    public AddProjectInteractor(AddProjectDataAccessInterface addProjectDataAccessInterface,
            AddProjectOutputBoundary addProjectOutputBoundary,
            ProjectFactory projectFactory) {
        this.userDataAccessObject = addProjectDataAccessInterface;
        this.addProjectPresenter = addProjectOutputBoundary;
        this.projectFactory = projectFactory;
    }

    @Override
    public void execute(AddProjectInputData addProjectInputData) {
        Project project = projectFactory.create(addProjectInputData.getProjectName());
        userDataAccessObject.addProject(project);

        AddProjectOutputData addProjectOutputData = new AddProjectOutputData(project.getName(), false);
        addProjectPresenter.prepareSuccessView(addProjectOutputData);
    }

}

package use_case.add_project;

import data_access.UserDataAccessObject;
import entity.ProjectFactory;
import junit.framework.TestCase;


public class AddProjectInteractorTest extends TestCase {

    public void testExecute() {
        AddProjectDataAccessInterface userRepository = new UserDataAccessObject();

        AddProjectInputData inputData = new AddProjectInputData("New Project");

        AddProjectOutputBoundary successPresenter = new AddProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(AddProjectOutputData project) {
                assertEquals("New Project", project.getProjectName());
            }

            @Override
            public void prepareFailView(String error) {
            }
        };

        AddProjectInputBoundary interactor = new AddProjectInteractor(userRepository, successPresenter, new ProjectFactory());
        interactor.execute(inputData);
    }
}
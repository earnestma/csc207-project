package use_case.delete_project;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import entity.ProjectFactory;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import use_case.add_project.*;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteProjectInteractorTest {
    public ExpectedException exceptionRule  = ExpectedException.none();
    @Test
    void execute() {
        DeleteProjectDataAccessInterface userRepository = new UserDataAccessObject();
        AddProjectDataAccessInterface addUserRepository = new UserDataAccessObject();

        AddProjectInputData addInputData = new AddProjectInputData("testDeleteProject");

        AddProjectOutputBoundary addSuccessPresenter = new AddProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(AddProjectOutputData project) {
            }
            @Override
            public void prepareFailView(String error) {
            }
        };

        AddProjectInputBoundary addInteractor = new AddProjectInteractor(addUserRepository, addSuccessPresenter, new ProjectFactory());
        addInteractor.execute(addInputData);

        DeleteProjectInputData inputData = new DeleteProjectInputData("testDeleteProject");
        DeleteProjectInputData fakeInputData = new DeleteProjectInputData("doesNotExist");

        DeleteProjectOutputBoundary successPresenter = new DeleteProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteProjectOutputData deletedProject) {
                ArrayList<Project> projectList = deletedProject.getProjectList();
                ArrayList<String> projectNameList = new ArrayList<>();
                for (Project project1 : projectList) {
                    projectNameList.add(project1.getName());
                }
                assertFalse(projectNameList.contains("testDeleteProject"));
            }

            @Override
            public void prepareFailView(String error) {
                exceptionRule.expect(NullPointerException.class);
                exceptionRule.expectMessage("Project does not exist");
            }
        };

        DeleteProjectInputBoundary interactor = new DeleteProjectInteractor(userRepository, successPresenter);
        interactor.execute(inputData);
        interactor.execute(fakeInputData);
    }
}

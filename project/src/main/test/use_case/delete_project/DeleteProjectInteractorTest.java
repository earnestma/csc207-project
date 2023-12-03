package use_case.delete_project;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DeleteProjectInteractorTest {
    public ExpectedException exceptionRule  = ExpectedException.none();
    @Test
    void execute() {
        DeleteProjectDataAccessInterface userRepository = new UserDataAccessObject();

        int lastProjectIndex = userRepository.listProjects().size() - 1;
        String deleteProject = userRepository.listProjects().get(lastProjectIndex).getName();

        DeleteProjectInputData inputData = new DeleteProjectInputData(deleteProject);
        DeleteProjectInputData fakeInputData = new DeleteProjectInputData("doesNotExist");

        DeleteProjectOutputBoundary successPresenter = new DeleteProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteProjectOutputData deletedProject) {
                ArrayList<Project> projectList = deletedProject.getProjectList();
                ArrayList<String> projectNameList = new ArrayList<>();
                for (Project project1 : projectList) {
                    projectNameList.add(project1.getName());
                }
                assertFalse(projectNameList.contains(deleteProject));
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
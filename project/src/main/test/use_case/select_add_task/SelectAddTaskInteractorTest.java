package use_case.select_add_task;

import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import junit.framework.TestCase;

public class SelectAddTaskInteractorTest extends TestCase {
    public void testExecute() {

        UserDataAccessInterface userRepository = new UserDataAccessObject();

        Project project = userRepository.listProjects().get(0);
        SelectAddTaskInputData inputData = new SelectAddTaskInputData(project);

        SelectAddTaskOutputBoundary successPresenter = new SelectAddTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectAddTaskOutputData response) {
                assertEquals(project, response.getProject());
            }
        };

        SelectAddTaskInputBoundary interactor = new SelectAddTaskInteractor(successPresenter);
        interactor.execute(inputData);
    }
}
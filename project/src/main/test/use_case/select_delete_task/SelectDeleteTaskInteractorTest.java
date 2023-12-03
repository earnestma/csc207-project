package use_case.select_delete_task;

import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import junit.framework.TestCase;
import use_case.select_add_task.*;

public class SelectDeleteTaskInteractorTest extends TestCase {
    public void testExecute() {

        UserDataAccessInterface userRepository = new UserDataAccessObject();

        Project project = userRepository.listProjects().get(0);
        SelectDeleteTaskInputData inputData = new SelectDeleteTaskInputData(project);

        SelectDeleteTaskOutputBoundary successPresenter = new SelectDeleteTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectDeleteTaskOutputData response) {
                assertEquals(project, response.getProject());
            }
        };
        SelectDeleteTaskInputBoundary interactor = new SelectDeleteTaskInteractor(successPresenter);
        interactor.execute(inputData);
    }
}
package interface_adapter.select_add_task;

import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import junit.framework.TestCase;
import use_case.select_add_task.*;

public class SelectAddTaskControllerTest extends TestCase {
    public void testExecute() {
        
        UserDataAccessInterface userRepository = new UserDataAccessObject();
        
        Project project = userRepository.listProjects().get(0);
        
        SelectAddTaskOutputBoundary successPresenter = new SelectAddTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectAddTaskOutputData response) {
                assertEquals(project, response.getProject());
            }
        };
        
        SelectAddTaskInputBoundary interactor = new SelectAddTaskInteractor(successPresenter);
        SelectAddTaskController controller = new SelectAddTaskController(interactor);
        controller.execute(project);
    }
}

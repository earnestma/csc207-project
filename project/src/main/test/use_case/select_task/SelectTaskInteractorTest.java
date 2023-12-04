package use_case.select_task;

import entity.Project;
import entity.Task;
import junit.framework.TestCase;

public class SelectTaskInteractorTest extends TestCase {
    public void testExecute() {

        Project project = new Project("project name", 1234);
        Task task = new Task("task name", Long.valueOf(1234));
        SelectTaskInputData inputData = new SelectTaskInputData(task, project);

        SelectTaskOutputBoundary successPresenter = new SelectTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectTaskOutputData response) {
                assertEquals(project, response.getProject());
                assertEquals(task, response.getTask());
            }
        };
        SelectTaskInputBoundary interactor = new SelectTaskInteractor(successPresenter);
        interactor.execute(inputData);
    }
}


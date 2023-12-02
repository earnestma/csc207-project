package use_case.delete_task;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import entity.Task;
import entity.TaskFactory;
import junit.framework.TestCase;
import use_case.add_task.*;

import java.util.ArrayList;

public class DeleteTaskInteractorTest extends TestCase {
    public void testExecute() {
        AddTaskInteractorTest.testExecute();

        UserDataAccessInterface userRepository = new UserDataAccessObject();
        DeleteTaskDataAccessInterface projectRepository = new ProjectDataAccessObject();

        Project project = userRepository.listProjects().get(0);
        DeleteTaskInputData inputData = new DeleteTaskInputData("testTask", project);

        DeleteTaskOutputBoundary successPresenter = new DeleteTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteTaskOutputData deletedTask) {
                ArrayList<Task> taskList = deletedTask.getTaskList();
                ArrayList<String> taskNameList = new ArrayList<>();
                for (Task task1 : taskList) {
                    taskNameList.add(task1.getName());
                }
                assertFalse(taskNameList.contains("testTask"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        DeleteTaskInputBoundary interactor = new DeleteTaskInteractor(projectRepository, successPresenter);
        interactor.execute(inputData);
    }
}
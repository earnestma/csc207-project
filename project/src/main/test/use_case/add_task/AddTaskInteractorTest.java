package use_case.add_task;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import entity.Task;
import entity.TaskFactory;
import junit.framework.TestCase;
import use_case.delete_task.DeleteTaskOutputBoundary;

import java.util.ArrayList;

public class AddTaskInteractorTest extends TestCase {
    public static void testExecute() {
        UserDataAccessInterface userRepository = new UserDataAccessObject();
        AddTaskDataAccessInterface projectRepository = new ProjectDataAccessObject();

        Project project = userRepository.listProjects().get(0);
        AddTaskInputData inputData = new AddTaskInputData("testTask", "2023-12-05", project);

        // creates a successPresenter that tests whether the test case is as we expect.
        AddTaskOutputBoundary successPresenter = new AddTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(AddTaskOutputData task) {
                // things to check: the output data is correct, and the task has been created in the DAO
                assertEquals("testTask", task.getTaskName());
                assertEquals("2023-12-05", task.getDueDate());

                ArrayList<Task> taskList = task.getTaskList();
                ArrayList<String> taskNameList = new ArrayList<>();
                for (Task task1 : taskList) {
                    taskNameList.add(task1.getName());
                }
                assertTrue(taskNameList.contains("testTask"));
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        AddTaskInputBoundary interactor = new AddTaskInteractor(projectRepository, successPresenter, new TaskFactory());
        interactor.execute(inputData);
    }
}
package use_case.delete_task;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import entity.Task;
import entity.TaskFactory;
import junit.framework.TestCase;
import org.junit.rules.ExpectedException;
import use_case.add_task.*;

import java.util.ArrayList;

public class DeleteTaskInteractorTest extends TestCase {
    public ExpectedException exceptionRule = ExpectedException.none();

    public void testExecute() {
        UserDataAccessInterface userRepository = new UserDataAccessObject();
        DeleteTaskDataAccessInterface projectRepository = new ProjectDataAccessObject();
        AddTaskDataAccessInterface addProjectRepository = new ProjectDataAccessObject();

        Project project = userRepository.listProjects().get(0);

        AddTaskInputData addInputData = new AddTaskInputData("testDeleteTask", "2023-12-05", project);

        // creates a successPresenter that tests whether the test case is as we expect.
        AddTaskOutputBoundary addSuccessPresenter = new AddTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(AddTaskOutputData task) {
            }

            @Override
            public void prepareFailView(String error) {
            }
        };

        AddTaskInputBoundary addInteractor = new AddTaskInteractor(addProjectRepository, addSuccessPresenter,
                new TaskFactory());
        addInteractor.execute(addInputData);

        DeleteTaskInputData inputData = new DeleteTaskInputData("testDeleteTask", project);
        DeleteTaskInputData fakeInputData = new DeleteTaskInputData("notExist", project);

        DeleteTaskOutputBoundary successPresenter = new DeleteTaskOutputBoundary() {
            @Override
            public void prepareSuccessView(DeleteTaskOutputData deletedTask) {
                ArrayList<Task> taskList = deletedTask.getTaskList();
                ArrayList<String> taskNameList = new ArrayList<>();
                for (Task task1 : taskList) {
                    taskNameList.add(task1.getName());
                }
                assertFalse(taskNameList.contains("testDeleteTask"));
            }

            @Override
            public void prepareFailView(String error) {
                exceptionRule.expectMessage("Task does not exist");
            }
        };

        DeleteTaskInputBoundary interactor = new DeleteTaskInteractor(projectRepository, successPresenter);
        interactor.execute(inputData);
        interactor.execute(fakeInputData);
    }
}

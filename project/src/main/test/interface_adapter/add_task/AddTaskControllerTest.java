package interface_adapter.add_task;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.Project;
import entity.Task;
import entity.TaskFactory;
import junit.framework.TestCase;
import org.junit.rules.ExpectedException;
import use_case.add_task.*;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class AddTaskControllerTest extends TestCase {
    public ExpectedException exceptionRule = ExpectedException.none();
    public void testExecute() {
        UserDataAccessInterface userRepository = new UserDataAccessObject();
        AddTaskDataAccessInterface projectRepository = new ProjectDataAccessObject();
        
        Project project = userRepository.listProjects().get(0);
        
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
                exceptionRule.expect(DateTimeParseException.class);
                exceptionRule.expectMessage("Invalid Date");
            }
        };
        
        AddTaskInputBoundary interactor = new AddTaskInteractor(projectRepository, successPresenter, new TaskFactory());
        AddTaskController controller = new AddTaskController(interactor);
        controller.execute("testTask", "2023-12-05", project); // Success
        controller.execute("failTask", "aaa", project); // Fail
    }
}


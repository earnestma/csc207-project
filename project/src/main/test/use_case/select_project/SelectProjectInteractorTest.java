package use_case.select_project;

import data_access.ProjectDataAccessObject;
import entity.Project;
import entity.Task;
import junit.framework.TestCase;

import java.util.ArrayList;

public class SelectProjectInteractorTest extends TestCase {
    public void testExecute() {
        
        Project project = new Project("project name", 1234);
        ArrayList<Task> taskList = project.getTaskList();
        SelectProjectInputData inputData = new SelectProjectInputData(project);
        ProjectDataAccessObject dao = new ProjectDataAccessObject();
        
        SelectProjectOutputBoundary successPresenter = new SelectProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectProjectOutputData response) {
                assertEquals(project, response.getProject());
                assertEquals(taskList, response.getTaskList());
            }
        };
        SelectProjectInputBoundary interactor = new SelectProjectInteractor(dao, successPresenter);
        interactor.execute(inputData);
    }
}
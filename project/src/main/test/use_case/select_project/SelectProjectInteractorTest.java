package use_case.select_project;

import data_access.ProjectDataAccessObject;
import entity.Project;
import junit.framework.TestCase;

public class SelectProjectInteractorTest extends TestCase {
    public void testExecute() {
        
        Project project = new Project("project name", 1234);
        SelectProjectInputData inputData = new SelectProjectInputData(project);
        ProjectDataAccessObject dao = new ProjectDataAccessObject();
        
        SelectProjectOutputBoundary successPresenter = new SelectProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectProjectOutputData response) {
                assertEquals(project, response.getProject());
            }
        };
        SelectProjectInputBoundary interactor = new SelectProjectInteractor(dao, successPresenter);
        interactor.execute(inputData);
    }
}
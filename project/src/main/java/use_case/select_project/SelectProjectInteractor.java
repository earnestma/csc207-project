package use_case.select_project;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public class SelectProjectInteractor implements SelectProjectInputBoundary {
    final SelectProjectOutputBoundary selectProjectPresenter;
    final SelectProjectDataAccessInterface projectDataAccessObject;
    
    public SelectProjectInteractor(SelectProjectDataAccessInterface selectProjectDataAccessInterface,
                                   SelectProjectOutputBoundary selectProjectPresenter){
        this.projectDataAccessObject = selectProjectDataAccessInterface;
        this.selectProjectPresenter = selectProjectPresenter;
    }
    @Override
    public void execute(SelectProjectInputData selectProjectInputData) {
        Project project = selectProjectInputData.getProject();

        long projectID = selectProjectInputData.getProject().getId();
        ArrayList<Task> taskList = this.projectDataAccessObject.getTasks(projectID);
        
        SelectProjectOutputData selectProjectOutputData = new SelectProjectOutputData(project, taskList);
        selectProjectPresenter.prepareSuccessView(selectProjectOutputData);
    }
}

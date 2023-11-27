package main.java.use_case.select_project;

import main.java.entity.Project;

public class SelectProjectInteractor implements SelectProjectInputBoundary {
    final SelectProjectOutputBoundary selectProjectPresenter;
    
    public SelectProjectInteractor(SelectProjectOutputBoundary selectProjectPresenter){
        this.selectProjectPresenter = selectProjectPresenter;
    }
    @Override
    public void execute(SelectProjectInputData selectProjectInputData) {
        Project project = selectProjectInputData.getProject();
        
        SelectProjectOutputData selectProjectOutputData = new SelectProjectOutputData(project);
        selectProjectPresenter.prepareSuccessView(selectProjectOutputData);
    }
}

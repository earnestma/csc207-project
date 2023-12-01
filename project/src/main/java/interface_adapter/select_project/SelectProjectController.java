package interface_adapter.select_project;

import use_case.select_project.SelectProjectInputBoundary;
import entity.Project;
import use_case.select_project.SelectProjectInputData;

public class SelectProjectController {
    final SelectProjectInputBoundary selectProjectInteractor;

    public SelectProjectController(SelectProjectInputBoundary selectProjectInteractor) {
        this.selectProjectInteractor = selectProjectInteractor;
    }
    
    public void execute(Project project) {
        SelectProjectInputData selectProjectInputData = new SelectProjectInputData(project);
        
        selectProjectInteractor.execute(selectProjectInputData);
    }
    
}

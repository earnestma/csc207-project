package interface_adapter.select_project;

import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.select_project.SelectProjectOutputBoundary;
import use_case.select_project.SelectProjectOutputData;

public class SelectProjectPresenter implements SelectProjectOutputBoundary {
    private final ProjectViewModel projectViewModel;
    private final ViewModelManager viewModelManager;
    
    public SelectProjectPresenter(ViewModelManager viewModelManager,
                                  ProjectViewModel projectViewModel){
        this.projectViewModel = projectViewModel;
        this.viewModelManager = viewModelManager;
    }
    @Override
    public void prepareSuccessView(SelectProjectOutputData response) {
        ProjectState projectState = projectViewModel.getState();
        projectState.setProject(response.getProject());
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();
        
        this.viewModelManager.setActiveView(projectViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

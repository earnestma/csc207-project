package interface_adapter.select_add_project;

import interface_adapter.ViewModelManager;
import interface_adapter.add_project.AddProjectState;
import interface_adapter.add_project.AddProjectViewModel;
import use_case.select_add_project.SelectAddProjectOutputBoundary;
import use_case.select_add_project.SelectAddProjectOutputData;

public class SelectAddProjectPresenter implements SelectAddProjectOutputBoundary {
    private final AddProjectViewModel addProjectViewModel;
    private final ViewModelManager viewModelManager;

    public SelectAddProjectPresenter(ViewModelManager viewModelManager,
            AddProjectViewModel addProjectViewModel) {
        this.addProjectViewModel = addProjectViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareSuccessView(SelectAddProjectOutputData response) {
        AddProjectState addProjectState = addProjectViewModel.getState();
        addProjectState.setUser(response.getUser());
        this.addProjectViewModel.setState(addProjectState);
        this.addProjectViewModel.firePropertyChanged();

        this.viewModelManager.setActiveView(addProjectViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

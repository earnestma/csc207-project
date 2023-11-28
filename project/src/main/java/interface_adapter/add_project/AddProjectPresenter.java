package interface_adapter.add_project;

import use_case.add_project.AddProjectOutputBoundary;

public class AddProjectPresenter implements AddProjectOutputBoundary {
/*
    private final AddProjectViewModel addProjectViewModel;
    private ViewModelManager ViewModelManager;

    public AddProjectPresenter(ViewModelManager ViewModelManager,
            AddProjectViewModel addProjectViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.addProjectViewModel = addProjectViewModel;
    }

    @Override
    public void prepareSuccessView(AddProjectOutputData response) {
        // switch to project view when Project is successfully added

        ProjectState projectState = projectViewModel.getState();
        projectState.setProjectName(response.getProjectName());
        projectState.setDueDate(response.getDueDate());
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }
    */
    @Override
    public void prepareFailView(String error) {

    }
}

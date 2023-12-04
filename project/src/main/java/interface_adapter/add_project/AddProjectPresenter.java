package interface_adapter.add_project;

import interface_adapter.ViewModelManager;
import interface_adapter.add_project.AddProjectViewModel;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.add_project.AddProjectOutputBoundary;
import use_case.add_project.AddProjectOutputData;

public class AddProjectPresenter implements AddProjectOutputBoundary {
    private final AddProjectViewModel addProjectViewModel;
    private final ProjectViewModel projectViewModel;
    private ViewModelManager ViewModelManager;

    public AddProjectPresenter(ViewModelManager ViewModelManager, AddProjectViewModel addProjectViewModel,
            ProjectViewModel projectViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.addProjectViewModel = addProjectViewModel;
        this.projectViewModel = projectViewModel;
    }

    @Override
    public void prepareSuccessView(AddProjectOutputData response) {
        ProjectState projectState = projectViewModel.getState();
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
    }
}

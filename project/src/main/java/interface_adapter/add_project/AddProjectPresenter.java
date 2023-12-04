package interface_adapter.add_project;

import interface_adapter.ViewModelManager;
import interface_adapter.home_view.HomeViewState;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.add_project.AddProjectOutputBoundary;
import use_case.add_project.AddProjectOutputData;
import use_case.add_project.AddProjectOutputBoundary;

public class AddProjectPresenter implements AddProjectOutputBoundary {
    private final AddProjectViewModel addProjectViewModel;
    private ViewModelManager ViewModelManager;
    private final HomeViewViewModel homeViewViewModel;

    public AddProjectPresenter(ViewModelManager ViewModelManager,
            AddProjectViewModel addProjectViewModel, HomeViewViewModel homeViewViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.addProjectViewModel = addProjectViewModel;
        this.homeViewViewModel = homeViewViewModel;
    }

    @Override
    public void prepareSuccessView(AddProjectOutputData response) {
        HomeViewState homeViewState = homeViewViewModel.getState();
        this.homeViewViewModel.setState(homeViewState);
        this.homeViewViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(homeViewViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}

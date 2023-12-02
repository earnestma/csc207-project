package interface_adapter.delete_project;

import interface_adapter.ViewModelManager;
import interface_adapter.home_view.HomeViewState;
import interface_adapter.home_view.HomeViewViewModel;
import use_case.delete_project.DeleteProjectOutputBoundary;
import use_case.delete_project.DeleteProjectOutputData;

public class DeleteProjectPresenter implements DeleteProjectOutputBoundary {

    private final DeleteProjectViewModel deleteProjectViewModel;
    private final HomeViewViewModel homeViewViewModel;
    private ViewModelManager ViewModelManager;

    public DeleteProjectPresenter(ViewModelManager ViewModelManager,
                                  DeleteProjectViewModel deleteProjectViewModel,
                                  HomeViewViewModel homeViewViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.deleteProjectViewModel = deleteProjectViewModel;
        this.homeViewViewModel = homeViewViewModel;
    }

    public void prepareSuccessView(DeleteProjectOutputData response) {
        HomeViewState homeViewState = homeViewViewModel.getState();
        this.homeViewViewModel.setState(homeViewState);
        this.homeViewViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(homeViewViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        this.deleteProjectViewModel.setMessage(error);
        this.deleteProjectViewModel.showMessage();
    }
}

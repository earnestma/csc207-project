package interface_adapter.select_delete_project;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_project.DeleteProjectState;
import interface_adapter.delete_project.DeleteProjectViewModel;
import use_case.select_delete_project.SelectDeleteProjectOutputBoundary;
import use_case.select_delete_project.SelectDeleteProjectOutputData;

public class SelectDeleteProjectPresenter implements SelectDeleteProjectOutputBoundary {
    private final DeleteProjectViewModel deleteProjectViewModel;
    private final ViewModelManager viewModelManager;

    public SelectDeleteProjectPresenter(ViewModelManager viewModelManager,
                                        DeleteProjectViewModel deleteProjectViewModel) {
        this.deleteProjectViewModel = deleteProjectViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareSuccessView(SelectDeleteProjectOutputData response) {
        DeleteProjectState deleteProjectState = deleteProjectViewModel.getState();
        deleteProjectState.setUser(response.getUser());
        this.deleteProjectViewModel.setState(deleteProjectState);
        this.deleteProjectViewModel.firePropertyChanged();

        this.viewModelManager.setActiveView(deleteProjectViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();

        System.out.println("123");
    }
}

package interface_adapter.go_project_view;


import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectViewModel;
import use_case.go_project_view.GoProjectViewOutputBoundary;
import view.ProjectView;

public class GoProjectViewPresenter implements GoProjectViewOutputBoundary {
    private final ProjectViewModel projectViewModel;
    private final ViewModelManager viewModelManager;

    public GoProjectViewPresenter(ViewModelManager viewModelManager,
                                  ProjectViewModel projectViewModel) {
        this.projectViewModel = projectViewModel;
        this.viewModelManager = viewModelManager;
    }

    public void prepareSuccessView() {
        this.viewModelManager.setActiveView(projectViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

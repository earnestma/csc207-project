package app;

import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.select_project.SelectProjectPresenter;
import use_case.select_project.SelectProjectDataAccessInterface;
import use_case.select_project.SelectProjectInteractor;

public class SelectProjectUseCaseFactory {
    private SelectProjectUseCaseFactory() {
    }

    public static SelectProjectController createSelectUseCase(ViewModelManager viewModelManager,
            ProjectViewModel projectViewModel,
            SelectProjectDataAccessInterface selectProjectDataAccessInterface) {
        SelectProjectPresenter outputBoundary = new SelectProjectPresenter(viewModelManager, projectViewModel);
        SelectProjectInteractor interactor = new SelectProjectInteractor(selectProjectDataAccessInterface,
                outputBoundary);
        return new SelectProjectController(interactor);
    }

}

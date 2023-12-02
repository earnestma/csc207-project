package app;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_project.DeleteProjectViewModel;
import interface_adapter.select_delete_project.SelectDeleteProjectController;
import interface_adapter.select_delete_project.SelectDeleteProjectPresenter;
import use_case.select_delete_project.SelectDeleteProjectInteractor;

public class SelectDeleteProjectUseCaseFactory {
    private SelectDeleteProjectUseCaseFactory() {}

    public static SelectDeleteProjectController createSelectDeleteProjectUseCase(ViewModelManager viewModelManager,
                                                                           DeleteProjectViewModel deleteProjectViewModel) {
        SelectDeleteProjectPresenter selectDeleteProjectPresenter = new SelectDeleteProjectPresenter(viewModelManager, deleteProjectViewModel);
        SelectDeleteProjectInteractor selectDeleteProjectInteractor = new SelectDeleteProjectInteractor(selectDeleteProjectPresenter);
        return new SelectDeleteProjectController(selectDeleteProjectInteractor);
    }
}

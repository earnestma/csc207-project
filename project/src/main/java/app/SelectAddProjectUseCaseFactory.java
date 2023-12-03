package app;

import interface_adapter.ViewModelManager;
import interface_adapter.add_project.AddProjectViewModel;
import interface_adapter.select_add_project.SelectAddProjectController;
import interface_adapter.select_add_project.SelectAddProjectPresenter;
import use_case.select_add_project.SelectAddProjectInteractor;

public class SelectAddProjectUseCaseFactory {
    private SelectAddProjectUseCaseFactory() {
    }

    public static SelectAddProjectController createSelectAddProjectUseCase(
            ViewModelManager viewModelManager, AddProjectViewModel addProjectViewModel) {

        SelectAddProjectPresenter selectAddProjectPresenter = new SelectAddProjectPresenter(viewModelManager,
                addProjectViewModel);
        SelectAddProjectInteractor selectAddProjectInteractor = new SelectAddProjectInteractor(
                selectAddProjectPresenter);
        return new SelectAddProjectController(selectAddProjectInteractor);
    }

}

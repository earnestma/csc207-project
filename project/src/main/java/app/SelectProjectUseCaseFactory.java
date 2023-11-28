package app;

import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.select_project.SelectProjectPresenter;
import use_case.select_project.SelectProjectInteractor;

public class SelectProjectUseCaseFactory {
    private SelectProjectUseCaseFactory(){}
    
    public static SelectProjectController createSelectUseCase(ViewModelManager viewModelManager,
                                                              ProjectViewModel projectViewModel){
        SelectProjectPresenter outputBoundary = new SelectProjectPresenter(viewModelManager, projectViewModel);
        SelectProjectInteractor interactor = new SelectProjectInteractor(outputBoundary);
        return new SelectProjectController(interactor);
    }
    
}

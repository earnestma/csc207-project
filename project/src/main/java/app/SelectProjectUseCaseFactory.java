package main.java.app;

import main.java.interface_adapter.ViewModelManager;
import main.java.interface_adapter.project.ProjectViewModel;
import main.java.interface_adapter.select_project.SelectProjectController;
import main.java.interface_adapter.select_project.SelectProjectPresenter;
import main.java.use_case.select_project.SelectProjectInteractor;

public class SelectProjectUseCaseFactory {
    private SelectProjectUseCaseFactory(){}
    
    public static SelectProjectController createSelectUseCase(ViewModelManager viewModelManager,
                                                              ProjectViewModel projectViewModel){
        SelectProjectPresenter outputBoundary = new SelectProjectPresenter(viewModelManager, projectViewModel);
        SelectProjectInteractor interactor = new SelectProjectInteractor(outputBoundary);
        return new SelectProjectController(interactor);
    }
    
}

package app;

import interface_adapter.ViewModelManager;
import interface_adapter.task.TaskViewModel;
import interface_adapter.select_task.SelectTaskController;
import interface_adapter.select_task.SelectTaskPresenter;
import use_case.select_task.SelectTaskInteractor;

public class SelectTaskUseCaseFactory {
    private SelectTaskUseCaseFactory() {}
    
    public static SelectTaskController createSelectUseCase(ViewModelManager viewModelManager,
                                                              TaskViewModel taskViewModel) {
        SelectTaskPresenter outputBoundary = new SelectTaskPresenter(viewModelManager, taskViewModel);
        SelectTaskInteractor interactor = new SelectTaskInteractor(outputBoundary);
        return new SelectTaskController(interactor);
    }
    
}

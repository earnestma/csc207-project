package app;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.select_delete_Task.SelectDeleteTaskController;
import interface_adapter.select_delete_Task.SelectDeleteTaskPresenter;
import use_case.select_delete_task.SelectDeleteTaskInteractor;

public class SelectDeleteTaskUseCaseFactory {
    private SelectDeleteTaskUseCaseFactory() {
    }

    public static SelectDeleteTaskController createSelectDeleteTaskUseCase(ViewModelManager viewModelManager,
            DeleteTaskViewModel deleteTaskViewModel) {
        SelectDeleteTaskPresenter selectDeleteTaskPresenter = new SelectDeleteTaskPresenter(viewModelManager,
                deleteTaskViewModel);
        SelectDeleteTaskInteractor selectDeleteTaskInteractor = new SelectDeleteTaskInteractor(
                selectDeleteTaskPresenter);
        return new SelectDeleteTaskController(selectDeleteTaskInteractor);
    }
}

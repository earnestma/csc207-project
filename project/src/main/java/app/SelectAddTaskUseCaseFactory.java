package app;

import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.select_add_task.SelectAddTaskController;
import interface_adapter.select_add_task.SelectAddTaskPresenter;
import use_case.select_add_task.SelectAddTaskInteractor;

public class SelectAddTaskUseCaseFactory {
    private SelectAddTaskUseCaseFactory() {}
    public static SelectAddTaskController createSelectAddTaskUseCase(ViewModelManager viewModelManager,
                                                               AddTaskViewModel addTaskViewModel) {
        SelectAddTaskPresenter selectAddTaskPresenter = new SelectAddTaskPresenter(viewModelManager, addTaskViewModel);
        SelectAddTaskInteractor selectAddTaskInteractor = new SelectAddTaskInteractor(selectAddTaskPresenter);
        return new SelectAddTaskController(selectAddTaskInteractor);
    }
}

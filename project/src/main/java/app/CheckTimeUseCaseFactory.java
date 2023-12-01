package app;

import interface_adapter.ViewModelManager;
import interface_adapter.check_remaining_time.CheckTimeController;
import interface_adapter.check_remaining_time.CheckTimePresenter;
import interface_adapter.task.TaskViewModel;
import use_case.check_remaining_time.CheckTimeInteractor;

public class CheckTimeUseCaseFactory {
    private CheckTimeUseCaseFactory() {}
    public static CheckTimeController createCheckTimeUseCase(ViewModelManager viewModelManager,
                                                             TaskViewModel taskViewModel) {
        CheckTimePresenter checkTimePresenter = new CheckTimePresenter(viewModelManager, taskViewModel);
        CheckTimeInteractor checkTimeInteractor = new CheckTimeInteractor(checkTimePresenter);
        return new CheckTimeController(checkTimeInteractor);
    }
}

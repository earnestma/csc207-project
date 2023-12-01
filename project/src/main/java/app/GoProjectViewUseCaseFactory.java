package app;

import interface_adapter.ViewModelManager;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.go_project_view.GoProjectViewPresenter;
import interface_adapter.project.ProjectViewModel;
import use_case.go_project_view.GoProjectViewInteractor;

public class GoProjectViewUseCaseFactory {
    private GoProjectViewUseCaseFactory() {}
    public static GoProjectViewController createGoProjectViewUseCase(ViewModelManager viewModelManager,
                                                               ProjectViewModel projectViewModel) {
        GoProjectViewPresenter goProjectViewPresenter = new GoProjectViewPresenter(viewModelManager, projectViewModel);
        GoProjectViewInteractor goProjectViewInteractor = new GoProjectViewInteractor(goProjectViewPresenter);
        return new GoProjectViewController(goProjectViewInteractor);
    }
}

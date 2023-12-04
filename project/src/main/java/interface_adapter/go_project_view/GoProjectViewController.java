package interface_adapter.go_project_view;

import use_case.go_project_view.GoProjectViewInputBoundary;

public class GoProjectViewController {
    final GoProjectViewInputBoundary goProjectViewInteractor;

    public GoProjectViewController(GoProjectViewInputBoundary goProjectViewInteractor) {
        this.goProjectViewInteractor = goProjectViewInteractor;
    }

    public void execute() {
        goProjectViewInteractor.execute();
    }
}

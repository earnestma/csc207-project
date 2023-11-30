package interface_adapter.go_project_view;

import use_case.go_project_view.GoProjectViewInputBoundary;
import use_case.go_project_view.GoProjectViewInputData;

public class GoProjectViewController {
    final GoProjectViewInputBoundary goProjectViewInteractor;
    public GoProjectViewController(GoProjectViewInputBoundary goProjectViewInteractor){
        this.goProjectViewInteractor = goProjectViewInteractor;
    }

    public void execute() {
        goProjectViewInteractor.execute();
    }
}

package use_case.go_project_view;

public class GoProjectViewInteractor implements GoProjectViewInputBoundary {
    final GoProjectViewOutputBoundary goProjectViewPresenter;

    public GoProjectViewInteractor(GoProjectViewOutputBoundary goProjectViewPresenter) {
        this.goProjectViewPresenter = goProjectViewPresenter;
    }

    @Override
    public void execute() {
        goProjectViewPresenter.prepareSuccessView();
    }
}

package use_case.go_home_view;

public class GoHomeViewInteractor implements GoHomeViewInputBoundary{
    final GoHomeViewOutputBoundary goHomeViewPresenter;
    
    public GoHomeViewInteractor(GoHomeViewOutputBoundary goHomeViewPresenter) {
        this.goHomeViewPresenter = goHomeViewPresenter;
    }
    
    public void execute() {
        goHomeViewPresenter.prepareSuccessView();
    }
}

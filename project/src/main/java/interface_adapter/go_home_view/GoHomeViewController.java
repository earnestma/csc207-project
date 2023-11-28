package interface_adapter.go_home_view;

import use_case.go_home_view.GoHomeViewInputBoundary;

public class GoHomeViewController {
    final GoHomeViewInputBoundary goHomeViewInteractor;
    public GoHomeViewController(GoHomeViewInputBoundary goHomeViewInteractor){
        this.goHomeViewInteractor = goHomeViewInteractor;
    }
    
    public void execute(){
        goHomeViewInteractor.execute();
    }
}

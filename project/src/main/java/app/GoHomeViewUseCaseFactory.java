package main.java.app;

import main.java.interface_adapter.ViewModelManager;
import main.java.interface_adapter.go_home_view.GoHomeViewController;
import main.java.interface_adapter.go_home_view.GoHomeViewPresenter;
import main.java.interface_adapter.home_view.HomeViewViewModel;
import main.java.use_case.go_home_view.GoHomeViewInteractor;

public class GoHomeViewUseCaseFactory {
    private GoHomeViewUseCaseFactory(){}
    public static GoHomeViewController createGoHomeViewUseCase(ViewModelManager viewModelManager,
                                                               HomeViewViewModel homeViewViewModel){
        GoHomeViewPresenter goHomeViewPresenter = new GoHomeViewPresenter(viewModelManager, homeViewViewModel);
        GoHomeViewInteractor goHomeViewInteractor = new GoHomeViewInteractor(goHomeViewPresenter);
        return new GoHomeViewController(goHomeViewInteractor);
    }
    
}

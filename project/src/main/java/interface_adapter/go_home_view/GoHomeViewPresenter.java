package interface_adapter.go_home_view;

import interface_adapter.ViewModelManager;
import interface_adapter.home_view.HomeViewViewModel;
import use_case.go_home_view.GoHomeViewOutputBoundary;

public class GoHomeViewPresenter implements GoHomeViewOutputBoundary {
    private final HomeViewViewModel homeViewViewModel;
    private final ViewModelManager viewModelManager;

    public GoHomeViewPresenter(ViewModelManager viewModelManager,
            HomeViewViewModel homeViewViewModel) {
        this.homeViewViewModel = homeViewViewModel;
        this.viewModelManager = viewModelManager;
    }

    public void prepareSuccessView() {
        this.viewModelManager.setActiveView(homeViewViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

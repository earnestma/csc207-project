package main.java.interface_adapter.check_remaining_time;

import main.java.interface_adapter.project.ProjectViewModel;
import main.java.use_case.check_remaining_time.CheckTimeOutputBoundary;
import main.java.use_case.check_remaining_time.CheckTimeOutputData;

// Implement boundary
public class CheckTimePresenter{
    /*
    private ViewModelManager ViewModelManager;
    private final CheckTimeViewModel checkTimeViewModel;
    private final ProjectViewModel tasksViewModel;

    public CheckTimePresenter(ViewModelManager ViewModelManager,
                              CheckTimeViewModel checkTimeViewModel,
                              ProjectViewModel tasksViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.checkTimeViewModel = checkTimeViewModel;
        this.tasksViewModel = tasksViewModel;
    }

    @Override
    public void prepareSuccessView(CheckTimeOutputData response) {
        // On success, switch to the logged in view.

        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername(response.getUsername());
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(loggedInViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
    */
}

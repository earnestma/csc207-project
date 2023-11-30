package interface_adapter.check_remaining_time;

import interface_adapter.ViewModelManager;
import interface_adapter.task.TaskViewModel;

import use_case.check_remaining_time.CheckTimeOutputBoundary;
import use_case.check_remaining_time.CheckTimeOutputData;

// Implement bo
public class CheckTimePresenter implements CheckTimeOutputBoundary{
    
    private ViewModelManager viewModelManager;
    private final TaskViewModel tasksViewModel;

    public CheckTimePresenter(ViewModelManager viewModelManager,
                              TaskViewModel tasksViewModel) {

        this.tasksViewModel = tasksViewModel;
    }

    @Override
    public void prepareSuccessView(CheckTimeOutputData response) {
        // On success, switch to the logged in view.
        String outputMessage = response.getOutputMessage();
        
        this.tasksViewModel.setMessage(outputMessage);
        this.tasksV
    }

    @Override
    public void prepareFailView(String error) {
        this.tasksViewModel.setMessage(error);
        this.tasksViewModel.showMessage();
    }
}

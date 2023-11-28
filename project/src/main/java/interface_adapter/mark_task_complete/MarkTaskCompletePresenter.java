package interface_adapter.mark_task_complete;

import interface_adapter.ViewModelManager;
import use_case.mark_task_complete.MarkTaskCompleteOutputBoundary;
import use_case.mark_task_complete.MarkTaskCompleteOutputData;

public class MarkTaskCompletePresenter implements MarkTaskCompelteOutputBoundary {

    private final TaskViewModel taskViewModel;
    private ViewModelManager viewModelManager;

    public MarkTaskCompletePresenter(ViewModelManager viewModelManager, TaskViewModel taskViewModel) {
        this.viewModelManager = viewModelManager;
        this.taskViewModel = taskViewModel;
    }

    @Override
    public void prepareSuccessView(MarkTaskCompelteOutputData response) {
        // Update task view model with status of task completion
        /*
        TaskState taskState = taskViewModel.getState();
        taskState.setTaskId(response.getTaskId();
        taskState.setCompletionStatus("Complete");
        task.taskViewModel.setState(taskState);
        this.taskViewModel.firePropertyChanged();
         */
    }

    @Override
    public void prepareFailView(String error) {

    }
}

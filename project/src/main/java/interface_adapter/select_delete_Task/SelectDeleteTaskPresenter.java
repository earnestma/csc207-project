package interface_adapter.select_delete_Task;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_task.DeleteTaskState;
import interface_adapter.delete_task.DeleteTaskViewModel;
import use_case.select_delete_task.SelectDeleteTaskOutputBoundary;
import use_case.select_delete_task.SelectDeleteTaskOutputData;

public class SelectDeleteTaskPresenter implements SelectDeleteTaskOutputBoundary {
    private final DeleteTaskViewModel deleteTaskViewModel;
    private final ViewModelManager viewModelManager;

    public SelectDeleteTaskPresenter(ViewModelManager viewModelManager,
                                     DeleteTaskViewModel deleteTaskViewModel) {
        this.deleteTaskViewModel = deleteTaskViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareSuccessView(SelectDeleteTaskOutputData response) {
        DeleteTaskState deleteTaskState = deleteTaskViewModel.getState();
        deleteTaskState.setProject(response.getProject());
        this.deleteTaskViewModel.setState(deleteTaskState);
        this.deleteTaskViewModel.firePropertyChanged();

        this.viewModelManager.setActiveView(deleteTaskViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

package interface_adapter.select_task;

import interface_adapter.ViewModelManager;
import interface_adapter.task.TaskState;
import interface_adapter.task.TaskViewModel;
import use_case.select_task.SelectTaskOutputBoundary;
import use_case.select_task.SelectTaskOutputData;

public class SelectTaskPresenter implements SelectTaskOutputBoundary {
    private final TaskViewModel taskViewModel;
    private final ViewModelManager viewModelManager;
    
    public SelectTaskPresenter(ViewModelManager viewModelManager,
                                  TaskViewModel taskViewModel){
        this.taskViewModel = taskViewModel;
        this.viewModelManager = viewModelManager;
    }
    @Override
    public void prepareSuccessView(SelectTaskOutputData response) {
        TaskState taskState = taskViewModel.getState();
        taskState.setTask(response.getTask());
        taskState.setPreviousProject(response.getProject());
        this.taskViewModel.setState(taskState);
        this.taskViewModel.firePropertyChanged();
        
        this.viewModelManager.setActiveView(taskViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

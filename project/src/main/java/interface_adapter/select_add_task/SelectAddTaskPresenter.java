package interface_adapter.select_add_task;

import interface_adapter.ViewModel;
import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskState;
import interface_adapter.add_task.AddTaskViewModel;
import use_case.select_add_task.SelectAddTaskOutputBoundary;
import use_case.select_add_task.SelectAddTaskOutputData;

public class SelectAddTaskPresenter implements SelectAddTaskOutputBoundary {
    private final AddTaskViewModel addTaskViewModel;
    private final ViewModelManager viewModelManager;

    public SelectAddTaskPresenter(ViewModelManager viewModelManager,
                                  AddTaskViewModel addTaskViewModel) {
        this.addTaskViewModel = addTaskViewModel;
        this.viewModelManager = viewModelManager;
    }

    @Override
    public void prepareSuccessView(SelectAddTaskOutputData response) {
        AddTaskState addTaskState = addTaskViewModel.getState();
        addTaskState.setProject(response.getProject());
        this.addTaskViewModel.setState(addTaskState);
        this.addTaskViewModel.firePropertyChanged();

        this.viewModelManager.setActiveView(addTaskViewModel.getViewName());
        this.viewModelManager.firePropertyChanged();
    }
}

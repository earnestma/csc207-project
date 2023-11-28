package interface_adapter.add_task;

import interface_adapter.ViewModelManager;
import use_case.add_task.AddTaskOutputBoundary;
import use_case.add_task.AddTaskOutputData;

public class AddTaskPresenter implements AddTaskOutputBoundary {

    private final AddTaskViewModel addTaskViewModel;
    private ViewModelManager ViewModelManager;

    public AddTaskPresenter(ViewModelManager ViewModelManager,
                            AddTaskViewModel addTaskViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.addTaskViewModel = addTaskViewModel;
    }

    @Override
    public void prepareSuccessView(AddTaskOutputData response) {
        // switch to project view when task is successfully added
        /*
        ProjectState projectState = projectViewModel.getState();
        projectState.setTaskName(response.getTaskName());
        projectState.setDueDate(response.getDueDate());
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged(); */
       
        
    }

    @Override
    public void prepareFailView(String error) {

    }
}

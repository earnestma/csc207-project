package interface_adapter.add_task;

import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.add_task.AddTaskOutputBoundary;
import use_case.add_task.AddTaskOutputData;

public class AddTaskPresenter implements AddTaskOutputBoundary {

    private final AddTaskViewModel addTaskViewModel;
    private final ProjectViewModel projectViewModel;
    private ViewModelManager ViewModelManager;

    public AddTaskPresenter(ViewModelManager ViewModelManager,
                            AddTaskViewModel addTaskViewModel, ProjectViewModel projectViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.addTaskViewModel = addTaskViewModel;
        this.projectViewModel = projectViewModel;
    }

    @Override
    public void prepareSuccessView(AddTaskOutputData response) {
        ProjectState projectState = projectViewModel.getState();
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}

package interface_adapter.add_task;

import entity.Task;
import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.add_task.AddTaskOutputBoundary;
import use_case.add_task.AddTaskOutputData;

import java.util.ArrayList;

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

        ArrayList<Task> taskList = response.getTaskList();
        projectState.setTaskList(taskList);
        // projectState.setTaskList(project.getTaskList());

        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        this.addTaskViewModel.setMessage(error);
        this.addTaskViewModel.showMessage();
    }
}

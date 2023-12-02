package interface_adapter.delete_task;

import entity.Task;
import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.delete_task.DeleteTaskOutputBoundary;
import use_case.delete_task.DeleteTaskOutputData;

import java.util.ArrayList;

public class DeleteTaskPresenter implements DeleteTaskOutputBoundary {

    private final DeleteTaskViewModel deleteTaskViewModel;
    private final ProjectViewModel projectViewModel;
    private ViewModelManager ViewModelManager;

    public DeleteTaskPresenter(ViewModelManager ViewModelManager,
                               DeleteTaskViewModel deleteTaskViewModel,
                               ProjectViewModel projectViewModel) {
        this.ViewModelManager = ViewModelManager;
        this.deleteTaskViewModel = deleteTaskViewModel;
        this.projectViewModel = projectViewModel;
    }

    public void prepareSuccessView(DeleteTaskOutputData response) {
        ProjectState projectState = projectViewModel.getState();
        ArrayList<Task> taskList = response.getTaskList();
        projectState.setTaskList(taskList);
        
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }
  
    @Override
    public void prepareFailView(String error) {
    }
}
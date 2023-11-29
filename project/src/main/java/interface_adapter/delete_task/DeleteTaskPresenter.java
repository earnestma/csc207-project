package interface_adapter.delete_task;

import interface_adapter.ViewModel;
import interface_adapter.ViewModelManager;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import use_case.delete_task.DeleteTaskOutputBoundary;
import use_case.delete_task.DeleteTaskOutputData;

import javax.swing.text.View;

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
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.ViewModelManager.setActiveView(projectViewModel.getViewName());
        this.ViewModelManager.firePropertyChanged();
    }
}

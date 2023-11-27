package interface_adapter.add_task;

import interface_adapter.ViewManagerModel;
import use_case.add_task.AddTaskOutputBoundary;
import use_case.add_task.AddTaskOutputData;

public class AddTaskPresenter implements AddTaskOutputBoundary {

    private final AddTaskViewModel addTaskViewModel;
    private ViewManagerModel viewManagerModel;

    public AddTaskPresenter(ViewManagerModel viewManagerModel,
                            AddTaskViewModel addTaskViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addTaskViewModel = addTaskViewModel;
    }

    @Override
    public void prepareSuccessView(AddTaskOutputData response) {
        // switch to project view when task is successfully added

        ProjectState projectState = projectViewModel.getState();
        projectState.setTaskName(response.getTaskName());
        projectState.setDueDate(response.getDueDate());
        this.projectViewModel.setState(projectState);
        this.projectViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(projectViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {

    }
}

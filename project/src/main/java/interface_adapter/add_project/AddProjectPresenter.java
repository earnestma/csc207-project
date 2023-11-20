package interface_adapter.add_project;

import interface_adapter.ViewManagerModel;
import use_case.add_project.AddProjectOutputBoundary;
import use_case.add_project.AddProjectOutputData;

public class AddProjectPresenter implements AddProjectOutputBoundary {

    private final AddProjectViewModel addProjectViewModel;
    private ViewManagerModel viewManagerModel;

    public AddProjectPresenter(ViewManagerModel viewManagerModel,
            AddProjectViewModel addProjectViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.addProjectViewModel = addProjectViewModel;
    }

    @Override
    public void prepareSuccessView(AddProjectOutputData response) {
        // switch to project view when Project is successfully added

        ProjectState projectState = projectViewModel.getState();
        projectState.setProjectName(response.getProjectName());
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

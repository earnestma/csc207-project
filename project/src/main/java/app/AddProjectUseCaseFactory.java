package app;

import java.io.IOException;

import entity.ProjectFactory;
import interface_adapter.ViewModelManager;
import interface_adapter.add_project.AddProjectController;
import interface_adapter.add_project.AddProjectViewModel;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import use_case.add_project.AddProjectDataAccessInterface;
import use_case.add_project.AddProjectInputBoundary;
import use_case.add_project.AddProjectInteractor;
import use_case.add_project.AddProjectOutputBoundary;
import interface_adapter.add_project.AddProjectPresenter;
import view.AddProjectView;

public class AddProjectUseCaseFactory {
    private AddProjectUseCaseFactory() {
    }

    public static AddProjectView create(
            ViewModelManager ViewModelManager, ProjectViewModel projectViewModel,
            AddProjectViewModel addProjectViewModel, AddProjectDataAccessInterface addProjectDataAccessObject,
            GoProjectViewController goProjectViewController, GoHomeViewController goHomeViewController,
            HomeViewViewModel homeViewViewModel) {

        try {
            AddProjectController addProjectController = addProjectUseCase(ViewModelManager, projectViewModel,
                    addProjectViewModel, addProjectDataAccessObject);

            return new AddProjectView(addProjectViewModel, addProjectController, goProjectViewController,
                    goHomeViewController, ViewModelManager, homeViewViewModel);
        } catch (IOException e) {
            return null;
        }
    }

    private static AddProjectController addProjectUseCase(ViewModelManager viewModelManager,
            ProjectViewModel projectViewModel, AddProjectViewModel addProjectViewModel,
            AddProjectDataAccessInterface addProjectDataAccessObject) throws IOException {

        AddProjectOutputBoundary addProjectOutputBoundary = new AddProjectPresenter(viewModelManager,
                addProjectViewModel, projectViewModel);

        ProjectFactory projectFactory = new ProjectFactory();

        AddProjectInputBoundary addProjectInteractor = new AddProjectInteractor(addProjectDataAccessObject,
                addProjectOutputBoundary, projectFactory);

        return new AddProjectController(addProjectInteractor);
    }

}

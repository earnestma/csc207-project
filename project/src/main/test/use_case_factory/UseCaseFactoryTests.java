package use_case_factory;

import app.*;
import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.delete_project.DeleteProjectViewModel;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.task.TaskViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class UseCaseFactoryTests {

    ViewModelManager viewModelManager;
    ProjectViewModel projectViewModel;
    HomeViewViewModel homeViewViewModel;
    DeleteTaskViewModel deleteTaskViewModel;
    AddTaskViewModel addTaskViewModel;
    TaskViewModel taskViewModel;
    DeleteProjectViewModel deleteProjectViewModel;

    ProjectDataAccessObject projectDataAccessObject;
    UserDataAccessObject userDataAccessObject;

    @BeforeEach
    void init() throws IOException {
        this.viewModelManager = new ViewModelManager();

        this.projectViewModel = new ProjectViewModel();
        this.homeViewViewModel = new HomeViewViewModel();
        this.deleteTaskViewModel = new DeleteTaskViewModel();
        this.addTaskViewModel = new AddTaskViewModel();
        this.taskViewModel = new TaskViewModel();
        this.deleteProjectViewModel = new DeleteProjectViewModel();

        this.projectDataAccessObject = new ProjectDataAccessObject();
        this.userDataAccessObject = new UserDataAccessObject();
    }

    @Test
    void addTaskUseCaseFactory() {
        GoProjectViewController goProjectViewController = GoProjectViewUseCaseFactory
                .createGoProjectViewUseCase(viewModelManager, projectViewModel);

        AddTaskUseCaseFactory.create(viewModelManager, projectViewModel, addTaskViewModel,
                projectDataAccessObject, goProjectViewController);

        DeleteTaskUseCaseFactory.create(viewModelManager, projectViewModel, deleteTaskViewModel,
                projectDataAccessObject, goProjectViewController);

    }

    @Test
    void CheckTimeUseCaseFactory() {
        CheckTimeUseCaseFactory.createCheckTimeUseCase(viewModelManager, taskViewModel);
    }

    @Test
    void DeleteProjectUseCaseFactory() {
        GoHomeViewController goHomeViewController = GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager,
                homeViewViewModel);
        DeleteProjectUseCaseFactory.create(viewModelManager, homeViewViewModel,
                deleteProjectViewModel, userDataAccessObject, goHomeViewController);
    }

    @Test
    void DeleteTaskUseCaseFactory() throws IOException {
        GoProjectViewController goProjectViewController = GoProjectViewUseCaseFactory
                .createGoProjectViewUseCase(viewModelManager, projectViewModel);
        DeleteTaskUseCaseFactory.deleteTaskUseCase(viewModelManager, projectViewModel,
                deleteTaskViewModel, projectDataAccessObject);
        DeleteTaskUseCaseFactory.create(viewModelManager, projectViewModel, deleteTaskViewModel,
                projectDataAccessObject, goProjectViewController);
    }

    @Test
    void GoHomeViewUseCaseFactory() {
        GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
    }

    @Test
    void GoProjectViewUseCaseFactory() {
        GoProjectViewUseCaseFactory.createGoProjectViewUseCase(viewModelManager, projectViewModel);
    }

    @Test
    void SelectAddTaskUseCaseFactory() {
        SelectAddTaskUseCaseFactory.createSelectAddTaskUseCase(viewModelManager, addTaskViewModel);
    }

    @Test
    void SelectDeleteProjectUseCaseFactory() {
        SelectDeleteProjectUseCaseFactory.createSelectDeleteProjectUseCase(viewModelManager,
                deleteProjectViewModel);
    }

    @Test
    void SelectDeleteTaskUseCcaseFactory() {
        SelectDeleteTaskUseCaseFactory.createSelectDeleteTaskUseCase(viewModelManager, deleteTaskViewModel);
    }

    @Test
    void SelectProjectUseCaseFactory() {
        SelectProjectUseCaseFactory.createSelectUseCase(viewModelManager, projectViewModel, projectDataAccessObject);
    }

    @Test
    void SelectTaskUseCaseFactory() {
        SelectTaskUseCaseFactory.createSelectUseCase(viewModelManager, taskViewModel);
    }

    @Test
    void Main() throws IOException {
        String[] args = {};
        Main.main(args);
    }
}

package app;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.check_remaining_time.CheckTimeController;
import interface_adapter.delete_project.DeleteProjectController;
import interface_adapter.delete_project.DeleteProjectViewModel;
import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_add_task.SelectAddTaskController;
import interface_adapter.select_delete_Task.SelectDeleteTaskController;
import interface_adapter.select_delete_project.SelectDeleteProjectController;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.select_task.SelectTaskController;
import interface_adapter.task.TaskViewModel;
import interface_adapter.select_add_project.SelectAddProjectController;
import interface_adapter.select_add_project.SelectAddProjectController;
import interface_adapter.add_project.AddProjectViewModel;
import view.AddProjectView;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // The main application window.
        JFrame application = new JFrame("TimeTask");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewModelManager viewModelManager = new ViewModelManager();
        new ViewManager(views, cardLayout, viewModelManager);

        // View Models
        ProjectViewModel projectViewModel = new ProjectViewModel();
        AddProjectViewModel addProjectViewModel = new AddProjectViewModel();
        HomeViewViewModel homeViewViewModel = new HomeViewViewModel();
        DeleteTaskViewModel deleteTaskViewModel = new DeleteTaskViewModel();
        AddTaskViewModel addTaskViewModel = new AddTaskViewModel();
        TaskViewModel taskViewModel = new TaskViewModel();
        DeleteProjectViewModel deleteProjectViewModel = new DeleteProjectViewModel();

        ProjectDataAccessObject projectDataAccessObject = new ProjectDataAccessObject();
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();

        // Views
        GoHomeViewController goHomeViewController = GoHomeViewUseCaseFactory
                .createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
        SelectAddProjectController selectAddProjectController = SelectAddProjectUseCaseFactory
                .createSelectAddProjectUseCase(viewModelManager, addProjectViewModel);
        SelectAddTaskController selectAddTaskController = SelectAddTaskUseCaseFactory
                .createSelectAddTaskUseCase(viewModelManager, addTaskViewModel);
        SelectTaskController selectTaskController = SelectTaskUseCaseFactory
                .createSelectUseCase(viewModelManager, taskViewModel);
        CheckTimeController checkTimeController = CheckTimeUseCaseFactory
                .createCheckTimeUseCase(viewModelManager, taskViewModel);
        DeleteProjectController deleteProjectController = DeleteProjectUseCaseFactory.deleteProjectUseCase(
                viewModelManager, homeViewViewModel,
                deleteProjectViewModel, userDataAccessObject);
        SelectDeleteProjectController selectDeleteProjectController = SelectDeleteProjectUseCaseFactory
                .createSelectDeleteProjectUseCase(viewModelManager,
                        deleteProjectViewModel);
        DeleteTaskController deleteTaskController = DeleteTaskUseCaseFactory.deleteTaskUseCase(
                viewModelManager, projectViewModel, deleteTaskViewModel, projectDataAccessObject);
        GoProjectViewController goProjectViewController = GoProjectViewUseCaseFactory
                .createGoProjectViewUseCase(viewModelManager, projectViewModel);
        SelectProjectController selectProjectController = SelectProjectUseCaseFactory
                .createSelectUseCase(viewModelManager, projectViewModel, projectDataAccessObject);
        SelectDeleteTaskController selectDeleteTaskController = SelectDeleteTaskUseCaseFactory
                .createSelectDeleteTaskUseCase(viewModelManager, deleteTaskViewModel);

        ProjectView projectView = new ProjectView(projectViewModel, goHomeViewController,
                selectAddTaskController,
                selectDeleteTaskController, selectTaskController);
        views.add(projectView, projectView.viewName);

        HomeViewView homeViewView = new HomeViewView(homeViewViewModel, selectProjectController,
                userDataAccessObject, selectAddProjectController, selectDeleteProjectController);
        views.add(homeViewView, homeViewView.viewName);

        AddProjectView addProjectView = AddProjectUseCaseFactory.create(viewModelManager, projectViewModel,
                addProjectViewModel, userDataAccessObject, goProjectViewController,
                goHomeViewController, homeViewViewModel);
        views.add(addProjectView, addProjectView.viewName);

        AddTaskView addTaskView = AddTaskUseCaseFactory.create(viewModelManager, projectViewModel,
                addTaskViewModel, projectDataAccessObject, goProjectViewController);
        views.add(addTaskView, addTaskView.viewName);

        DeleteProjectView deleteProjectView = DeleteProjectUseCaseFactory.create(viewModelManager,
                homeViewViewModel,
                deleteProjectViewModel, userDataAccessObject, goHomeViewController);
        views.add(deleteProjectView, deleteProjectView.viewName);

        DeleteTaskView deleteTaskView = DeleteTaskUseCaseFactory.create(viewModelManager, projectViewModel,
                deleteTaskViewModel,
                projectDataAccessObject, goProjectViewController);
        views.add(deleteTaskView, deleteTaskView.viewName);

        TaskView taskView = new TaskView(taskViewModel, selectProjectController, checkTimeController,
                deleteTaskController);
        views.add(taskView, taskView.viewName);

        viewModelManager.setActiveView(homeViewView.viewName);
        viewModelManager.firePropertyChanged();

        application.pack();
        application.setSize(400, 400);
        application.setResizable(false);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}

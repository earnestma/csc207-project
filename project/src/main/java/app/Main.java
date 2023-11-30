package app;

import data_access.ProjectDataAccessObject;
import data_access.UserDataAccessObject;
import interface_adapter.ViewModelManager;
import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_add_task.SelectAddTaskController;
import interface_adapter.select_delete_Task.SelectDeleteTaskController;
import interface_adapter.select_project.SelectProjectController;
import view.AddTaskView;
import view.HomeViewView;
import view.ProjectView;
import view.ViewManager;
import view.DeleteTaskView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // The main application window.
        JFrame application = new JFrame("Scheduler");
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
        HomeViewViewModel homeViewViewModel = new HomeViewViewModel();
        DeleteTaskViewModel deleteTaskViewModel = new DeleteTaskViewModel();
        AddTaskViewModel addTaskViewModel = new AddTaskViewModel();

        ProjectDataAccessObject projectDataAccessObject = new ProjectDataAccessObject();
        UserDataAccessObject userDataAccessObject = new UserDataAccessObject();
        
        // Views
        GoHomeViewController goHomeViewController =
                GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
        SelectAddTaskController selectAddTaskController =
                SelectAddTaskUseCaseFactory.createSelectAddTaskUseCase(viewModelManager, addTaskViewModel);
        SelectDeleteTaskController selectDeleteTaskController =
                SelectDeleteTaskUseCaseFactory.createSelectDeleteTaskUseCase(viewModelManager, deleteTaskViewModel);
        ProjectView projectView = new ProjectView(projectViewModel, goHomeViewController, selectAddTaskController, selectDeleteTaskController);
        views.add(projectView, projectView.viewName);

        SelectProjectController selectProjectController =
                SelectProjectUseCaseFactory.createSelectUseCase(viewModelManager, projectViewModel);
        HomeViewView homeViewView = new HomeViewView(homeViewViewModel, selectProjectController, userDataAccessObject);
        views.add(homeViewView, homeViewView.viewName);
      
        GoProjectViewController goProjectViewController =
                GoProjectViewUseCaseFactory.createGoProjectViewUseCase(viewModelManager, projectViewModel);
        AddTaskView addTaskView = AddTaskUseCaseFactory.create(viewModelManager, projectViewModel, addTaskViewModel, projectDataAccessObject, goProjectViewController);
        views.add(addTaskView, addTaskView.viewName);
      
        DeleteTaskView deleteTaskView = DeleteTaskUseCaseFactory.create(viewModelManager, projectViewModel, deleteTaskViewModel,
                projectDataAccessObject, goProjectViewController);
        views.add(deleteTaskView, deleteTaskView.viewName);
       
        
        
        
        
        
        viewModelManager.setActiveView(homeViewView.viewName);
        viewModelManager.firePropertyChanged();

        application.pack();
        application.setSize(400, 400);
        application.setResizable(false);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}

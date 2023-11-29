package app;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_project.SelectProjectController;
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

        // Views
        GoHomeViewController goHomeViewController =
                GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
        ProjectView projectView = new ProjectView(projectViewModel, goHomeViewController);
        views.add(projectView, projectView.viewName);

        SelectProjectController selectProjectController =
                SelectProjectUseCaseFactory.createSelectUseCase(viewModelManager, projectViewModel);
        HomeViewView homeViewView = new HomeViewView(homeViewViewModel, selectProjectController);
        views.add(homeViewView, homeViewView.viewName);

        DeleteTaskView deleteTaskView = DeleteTaskUseCaseFactory.create(viewModelManager, projectViewModel, deleteTaskViewModel,
                addTaskDataAccessObject, goProjectViewController);
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

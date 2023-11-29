package app;

import interface_adapter.ViewModelManager;
import interface_adapter.check_remaining_time.CheckTimeController;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.select_task.SelectTaskController;
import interface_adapter.task.TaskViewModel;
import view.HomeViewView;
import view.ProjectView;
import view.TaskView;
import view.ViewManager;

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
        TaskViewModel taskViewModel = new TaskViewModel();

        // Controllers
        GoHomeViewController goHomeViewController =
                GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
        SelectProjectController selectProjectController =
                SelectProjectUseCaseFactory.createSelectUseCase(viewModelManager, projectViewModel);
        SelectTaskController selectTaskController =
                SelectTaskUseCaseFactory.createSelectUseCase(viewModelManager, taskViewModel);
        CheckTimeController checkTimeController =
                CheckTimeUseCaseFactory.createCheckTimeUseCase(viewModelManager, taskViewModel);
        
        //Views
        ProjectView projectView = new ProjectView(projectViewModel, goHomeViewController, selectTaskController);
        views.add(projectView, projectView.viewName);

        HomeViewView homeViewView = new HomeViewView(homeViewViewModel, selectProjectController);
        views.add(homeViewView, homeViewView.viewName);
        
        TaskView taskView = new TaskView(taskViewModel, selectProjectController, checkTimeController);
        views.add(taskView, taskView.viewName);
        
        // Make sure start at home view
        viewModelManager.setActiveView(homeViewView.viewName);
        viewModelManager.firePropertyChanged();

        application.pack();
        application.setSize(400, 400);
        application.setResizable(false);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}

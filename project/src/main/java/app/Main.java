package main.java.app;

import javax.swing.*;
import java.awt.*;

import main.java.interface_adapter.ViewModelManager;
import main.java.interface_adapter.go_home_view.GoHomeViewController;
import main.java.interface_adapter.home_view.HomeViewViewModel;
import main.java.interface_adapter.project.ProjectViewModel;
import main.java.interface_adapter.select_project.SelectProjectController;
import main.java.view.HomeViewView;
import main.java.view.ProjectView;
import main.java.view.ViewManager;

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

        // Views
        GoHomeViewController goHomeViewController =
                GoHomeViewUseCaseFactory.createGoHomeViewUseCase(viewModelManager, homeViewViewModel);
        ProjectView projectView = new ProjectView(projectViewModel, goHomeViewController);
        views.add(projectView, projectView.viewName);

        SelectProjectController selectProjectController =
                SelectProjectUseCaseFactory.createSelectUseCase(viewModelManager, projectViewModel);
        HomeViewView homeViewView = new HomeViewView(homeViewViewModel, selectProjectController);
        views.add(homeViewView, homeViewView.viewName);
        
        
        
        
        
        
        
        viewModelManager.setActiveView(homeViewView.viewName);
        viewModelManager.firePropertyChanged();

        application.pack();
        application.setSize(400, 400);
        application.setResizable(false);
        application.setLocationRelativeTo(null);
        application.setVisible(true);
    }
}

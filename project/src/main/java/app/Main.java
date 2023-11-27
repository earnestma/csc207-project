package main.java.app;

import javax.swing.*;
import java.awt.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import main.java.entity.Task;
import main.java.interface_adapter.ViewManagerModel;
import main.java.interface_adapter.check_remaining_time.CheckTimePresenter;
import main.java.interface_adapter.home_view.HomeViewViewModel;
import main.java.interface_adapter.project.ProjectViewModel;
import main.java.use_case.check_remaining_time.CheckTimeInputData;
import main.java.use_case.check_remaining_time.CheckTimeInteractor;
import main.java.use_case.check_remaining_time.CheckTimeOutputBoundary;
import main.java.view.HomeViewView;
import main.java.view.ProjectView;
import main.java.view.ViewManager;

public class Main {
    public static void main(String[] args) {
        // The main application window.
        JFrame application = new JFrame("Scheduler");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        application.setSize(400, 400);
        application.setResizable(false);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // View Models
        ProjectViewModel projectViewModel = new ProjectViewModel();
        HomeViewViewModel homeViewViewModel = new HomeViewViewModel();

        // Views
        ProjectView projectView = new ProjectView(projectViewModel);
        views.add(projectView, projectView.viewName);

        HomeViewView homeViewView = new HomeViewView(homeViewViewModel);
        views.add(homeViewView, homeViewView.viewName);

        viewManagerModel.setActiveView(homeViewView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}

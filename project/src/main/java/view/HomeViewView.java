package view;

import data_access.UserDataAccessObject;
import entity.Project;
import interface_adapter.home_view.HomeViewViewModel;
import interface_adapter.select_add_project.SelectAddProjectController;
import interface_adapter.select_delete_project.SelectDeleteProjectController;
import interface_adapter.select_project.SelectProjectController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class HomeViewView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "home view";
    private final HomeViewViewModel homeViewViewModel;
    private ArrayList<Project> projects;
    private final SelectProjectController selectProjectController;
    private final SelectDeleteProjectController selectDeleteProjectController;
    private final UserDataAccessObject userDataAccessObject;
    private BorderLayout borderLayout;
    private final SelectAddProjectController selectAddProjectController;

    public HomeViewView(HomeViewViewModel homeViewViewModel,
            SelectProjectController selectProjectController,
            UserDataAccessObject userDataAccessObject,
            SelectAddProjectController selectAddProjectController,
            SelectDeleteProjectController selectDeleteProjectController) {

        borderLayout = new BorderLayout();
        this.setLayout(borderLayout);

        this.homeViewViewModel = homeViewViewModel;
        this.homeViewViewModel.addPropertyChangeListener(this);
        this.selectProjectController = selectProjectController;
        this.selectDeleteProjectController = selectDeleteProjectController;
        this.selectAddProjectController = selectAddProjectController;

        this.userDataAccessObject = userDataAccessObject;

        projects = userDataAccessObject.listProjects();
        projects.remove(0);

        updateView();
    }

    public void updateView() {
        java.util.List<JPanel> panelList = new java.util.ArrayList<>();

        JPanel headerPanel = createHeaderPanel();
        JPanel footerPanel = createFooterPanel();

        int numProjects = projects.size();

        for (Project project : projects) {
            JPanel panel = createProjectPanel(project);
            panelList.add(panel);
        }

        if (numProjects <= 5) {
            int missing = 5 - numProjects;
            for (int i = 1; i <= missing; i++) {
                JPanel panel = createEmptyPanel();
                panelList.add(panel);
            }
        }

        // Create a main panel to hold the list of panels vertically
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Add each panel to the main panel
        for (JPanel panel : panelList) {
            mainPanel.add(panel);
        }

        // Create a JScrollPane to allow scrolling
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        this.add(headerPanel, BorderLayout.NORTH);
        this.add(scrollPane, BorderLayout.CENTER);
        this.add(footerPanel, BorderLayout.SOUTH);
    }

    public JPanel createHeaderPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel label = new JLabel(homeViewViewModel.PROJECTS_LABEL);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panel.add(label, BorderLayout.WEST);

        JButton addProjectButton = new JButton(homeViewViewModel.ADD_PROJECT_BUTTON_LABEL);

        addProjectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectAddProjectController.execute(null);
                    }
                });

        addProjectButton.setPreferredSize(new Dimension(100, 30));
        addProjectButton.setMargin(new Insets(0, 0, 0, 0));
        addProjectButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addProjectButton.setFocusPainted(false);
        addProjectButton.setContentAreaFilled(false);
        addProjectButton.setBorderPainted(true);
        addProjectButton.setOpaque(false);
        panel.add(addProjectButton, BorderLayout.EAST);

        return panel;
    }

    private JPanel createProjectPanel(Project project) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));

        JButton projectButton = new JButton(project.getName());

        projectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectProjectController.execute(project);
                    }
                });

        projectButton.setPreferredSize(new Dimension(390, 50));
        projectButton.setHorizontalAlignment(SwingConstants.LEFT);
        projectButton.setMargin(new Insets(0, 0, 0, 0));
        projectButton.setFocusPainted(false);
        projectButton.setContentAreaFilled(false);
        projectButton.setBorderPainted(true);
        projectButton.setOpaque(false);
        panel.add(projectButton, BorderLayout.WEST);

        return panel;
    }

    private JPanel createEmptyPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 50));

        return panel;
    }

    private JPanel createFooterPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JButton deleteProjectButton = new JButton(homeViewViewModel.DELETE_PROJECT_BUTTON_LABEL);

        deleteProjectButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectDeleteProjectController.execute(null);
                    }
                });

        deleteProjectButton.setPreferredSize(new Dimension(100, 30));
        deleteProjectButton.setMargin(new Insets(0, 0, 0, 0));
        deleteProjectButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        deleteProjectButton.setFocusPainted(false);
        deleteProjectButton.setContentAreaFilled(false);
        deleteProjectButton.setBorderPainted(true);
        deleteProjectButton.setOpaque(false);
        panel.add(deleteProjectButton, BorderLayout.WEST);

        return panel;
    }

    public void clearAll() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.clearAll();
        projects = userDataAccessObject.listProjects();
        projects.remove(0);
        this.updateView();
    }
}

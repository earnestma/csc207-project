package view;

import entity.Project;
import entity.Task;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.project.ProjectState;
import interface_adapter.project.ProjectViewModel;
import interface_adapter.select_add_task.SelectAddTaskController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class ProjectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "project";
    private final ProjectViewModel projectViewModel;
    private final SelectAddTaskController selectAddTaskController;
    private String projectName;
    private ArrayList<Task> taskList;
    private GoHomeViewController goHomeViewController;

    public ProjectView(ProjectViewModel projectViewModel,
                       GoHomeViewController goHomeViewController,
                       SelectAddTaskController selectAddTaskController){
        this.setLayout(new BorderLayout());
        
        this.projectViewModel = projectViewModel;
        this.projectViewModel.addPropertyChangeListener(this);
        projectName = "";
        taskList = new ArrayList<Task>();
        
        this.goHomeViewController = goHomeViewController;
        this.selectAddTaskController = selectAddTaskController;
    }

    public void updateView(){
        java.util.List<JPanel> panelList = new java.util.ArrayList<>();

        JPanel headerPanel = createHeaderPanel();
        JPanel footerPanel = createFooterPanel();

        int numTasks = taskList.size();

        for (Task task: taskList){
            JPanel panel = createTaskPanel(task.getName());
            panelList.add(panel);
        }

        // To fill up empty space
        if (numTasks <= 5)
        {
            int missing = 5 - numTasks;
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

    public JPanel createHeaderPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JLabel label = new JLabel(projectName);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        panel.add(label, BorderLayout.WEST);

        JButton addTaskButton = new JButton(projectViewModel.ADD_TASK_BUTTON_LABEL);

        addTaskButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        selectAddTaskController.execute(new Project(projectName));
                    }
                }
        );

        addTaskButton.setPreferredSize(new Dimension(100, 30));
        addTaskButton.setMargin(new Insets(0, 0, 0, 0));
        addTaskButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        addTaskButton.setFocusPainted(false);
        addTaskButton.setContentAreaFilled(false);
        addTaskButton.setBorderPainted(true);
        addTaskButton.setOpaque(false);
        panel.add(addTaskButton, BorderLayout.EAST);

        return panel;
    }

    private JPanel createTaskPanel(String taskName) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setSize(new Dimension(300, 50));
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));


        JButton taskButton = new JButton(taskName);

        taskButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(null,"CHANGE TO TASK VIEW");
                    }
                }
        );

        taskButton.setPreferredSize(new Dimension(390, 50));
        taskButton.setHorizontalAlignment(SwingConstants.LEFT);
        taskButton.setMargin(new Insets(0, 0, 0, 0));
        taskButton.setFocusPainted(false);
        taskButton.setContentAreaFilled(false);
        taskButton.setBorderPainted(true);
        taskButton.setOpaque(false);
        panel.add(taskButton, BorderLayout.WEST);

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
        
        JButton goBackButton = new JButton(projectViewModel.HOME_PAGE_BUTTON_LABEL);

        goBackButton.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        goHomeViewController.execute();
                    }
                }
        );

        goBackButton.setPreferredSize(new Dimension(100, 30));
        goBackButton.setMargin(new Insets(0, 0, 0, 0));
        goBackButton.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        goBackButton.setFocusPainted(false);
        goBackButton.setContentAreaFilled(false);
        goBackButton.setBorderPainted(true);
        goBackButton.setOpaque(false);
        panel.add(goBackButton, BorderLayout.WEST);

        return panel;
    }


    public void clearAll(){
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

        ProjectState state = (ProjectState) evt.getNewValue();

        projectName = state.getProject().getName();
        taskList = state.getProject().getTaskList();

        this.updateView();
    }
}

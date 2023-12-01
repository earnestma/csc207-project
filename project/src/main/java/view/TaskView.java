package view;

import entity.Project;
import entity.Task;
import interface_adapter.check_remaining_time.CheckTimeController;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.task.TaskState;
import interface_adapter.task.TaskViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class TaskView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "task";
    private String taskName;
    private String dueDateTime;
    private final TaskViewModel taskViewModel;
    private final SelectProjectController selectProjectController;
    private final CheckTimeController checkTimeController;
    private Task task;
    private Project project;
    
    public TaskView(TaskViewModel taskViewModel,
                    SelectProjectController selectProjectController,
                    CheckTimeController checkTimeController) {
        this.taskViewModel = taskViewModel;
        this.taskViewModel.addPropertyChangeListener(this);
        
        this.selectProjectController = selectProjectController;
        this.checkTimeController = checkTimeController;
    }
    
    private void updateView() {
        // Create three panels
        JPanel panel1 = createTaskPanel();
        JPanel panel2 = createDueDatePanel();
        JPanel panel3 = createButtonsPanel();
        this.setSize(new Dimension(400, 400));
        
        // Set the layout manager of the content pane to BoxLayout
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        
        // Calculate heights for each section
        int frameHeight = this.getHeight();
        int topHeight = 11 * frameHeight / 20;
        int bottomHeight = (frameHeight - topHeight) / 2;
        
        // Set preferred sizes for each panel
        panel1.setPreferredSize(new Dimension(this.getWidth(), topHeight));
        panel2.setPreferredSize(new Dimension(this.getWidth(), bottomHeight / 2));
        panel3.setPreferredSize(new Dimension(this.getWidth(), bottomHeight / 2));
        
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
    }
    
    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        
        JButton backButton = createBackButton();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(40, 10, 0, 12);
        panel.add(backButton, gbc);
        
        JButton timeButton = createTimeButton();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(40, 12, 0, 12);
        panel.add(timeButton, gbc);
        
        JButton completeButton = createCompleteButton();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(40, 12, 0, 10);
        panel.add(completeButton, gbc);
        
        return panel;
    }
    
    private JPanel createTaskPanel() 
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JLabel title = new JLabel(taskViewModel.TASK_LABEL);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        panel.add(title);
        
        // Add text to the left of the panel
        JTextArea text = new JTextArea(task.getName());
        text.setBorder(BorderFactory.createEmptyBorder(0, 14, 0, 0));
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setSize(new Dimension(370, 400));
        text.setBackground(UIManager.getColor ( "Panel.background" ));
        
        // Add components to the panel
        panel.add(text);
        
        return panel;
    }
    
    private JPanel createDueDatePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        // Add text to the left of the panel
        JLabel label = new JLabel(taskViewModel.DUE_DATE_LABEL);
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        JLabel dueTime = new JLabel(String.valueOf(task.getDueDate()));
        dueTime.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        dueTime.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Add components to the panel
        panel.add(label);
        panel.add(dueTime);
        
        return panel;
    }
    
    private JButton createBackButton() {
        JButton button = new JButton(taskViewModel.GO_BACK_BUTTON_LABEL);
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {selectProjectController.execute(project);
            }
        });
        return button;
    }
    
    private JButton createTimeButton() {
        JButton button = new JButton(taskViewModel.TIME_BUTTON_LABEL);
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkTimeController.execute(task.hasDueDate(), task.getDueDate());
            }
        });
        return button;
    }
    
    private JButton createCompleteButton() {
        JButton button = new JButton(taskViewModel.COMPLETE_BUTTON_LABEL);
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "ASK IF SURE, MARK COMPLETE, " +
                        "DELETE AND SWITCH BACK TO PROJECT");
            }
        });
        return button;
    }
    
    private void clearAll() {
        this.removeAll();
        this.revalidate();
        this.repaint();
    }
    
    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
    
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            this.clearAll();
            
            TaskState state = (TaskState) evt.getNewValue();
            
            task = state.getTask();
            project = state.getPreviousProject();
            
            this.updateView();
        }
        else if (evt.getPropertyName().equals("message")) {
            String message = (String) evt.getNewValue();
            showMessage(message);
        }
    }
}

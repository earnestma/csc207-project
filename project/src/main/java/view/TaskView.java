package view;

import interface_adapter.select_task.SelectTaskController;
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
    private SelectTaskController selectTaskController;
    
    public TaskView(TaskViewModel taskViewModel,
                    SelectTaskController selectTaskController){
        this.taskViewModel = taskViewModel;
        this.selectTaskController = selectTaskController;
        taskName = "";
        dueDateTime = "";
        updateView();
    }
    
    private void updateView(){
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
    
    private static JPanel createButtonsPanel() {
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
        
        panel.setBackground(Color.WHITE);
        return panel;
    }
    
    private static JPanel createTaskPanel(){
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        JLabel title = new JLabel("TASK");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
        panel.add(title);
        
        // Add text to the left of the panel
        JTextArea text = new JTextArea("TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT " +
                "TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT TASK... TEXT ");
        text.setBorder(BorderFactory.createEmptyBorder(0, 14, 0, 0));
        text.setEditable(false);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        text.setSize(new Dimension(370, 400));
        
        // Add components to the panel
        panel.add(text);
        
        panel.setBackground(Color.WHITE);
        
        return panel;
    }
    
    private static JPanel createDueDatePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));
        
        // Add text to the left of the panel
        JLabel label = new JLabel("Due Date:");
        label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        label.setFont(new Font("Arial", Font.BOLD, 18));
        
        // Add components to the panel
        panel.add(label);
        
        panel.setBackground(Color.WHITE);
        
        return panel;
    }
    
    private static JButton createBackButton() {
        JButton button = new JButton("Back");
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "SWITCH BACK TO PROJECT VIEW (MAKE SURE CORRECT PROJECT)");
            }
        });
        return button;
    }
    
    private static JButton createTimeButton() {
        JButton button = new JButton("Time");
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "SHOW TIME HERE");
            }
        });
        return button;
    }
    
    private static JButton createCompleteButton() {
        JButton button = new JButton("Complete");
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(button, "MARK COMPLETE, DELETE AND SWITCH BACK TO PROJECT");
            }
        });
        return button;
    }
    
    private void clearAll(){
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
        
        TaskState state = (TaskState) evt.getNewValue();
        
        taskName = state.getTask().getName();
        
        this.updateView();
    }
}

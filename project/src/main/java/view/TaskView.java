package view;

import entity.Project;
import entity.Task;
import interface_adapter.check_remaining_time.CheckTimeController;
import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.select_project.SelectProjectController;
import interface_adapter.task.TaskState;
import interface_adapter.task.TaskViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.format.DateTimeFormatter;

public class TaskView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "task";
    private String taskName;
    private String dueDateTime;
    private final TaskViewModel taskViewModel;
    private final SelectProjectController selectProjectController;
    private final CheckTimeController checkTimeController;
    private final DeleteTaskController deleteTaskController;
    private Task task;
    private Project project;

    public TaskView(TaskViewModel taskViewModel,
            SelectProjectController selectProjectController,
            CheckTimeController checkTimeController,
            DeleteTaskController deleteTaskController) {
        this.taskViewModel = taskViewModel;
        this.taskViewModel.addPropertyChangeListener(this);

        this.selectProjectController = selectProjectController;
        this.checkTimeController = checkTimeController;
        this.deleteTaskController = deleteTaskController;
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
        panel2.setPreferredSize(new Dimension(this.getWidth(), 3 * bottomHeight / 4));
        panel3.setPreferredSize(new Dimension(this.getWidth(), bottomHeight / 4));

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
        gbc.insets = new Insets(20, 10, 0, 12);
        panel.add(backButton, gbc);

        JButton timeButton = createTimeButton();
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 12, 0, 12);
        panel.add(timeButton, gbc);

        JButton completeButton = createCompleteButton();
        gbc.gridx = 2;
        gbc.gridy = 0;
        gbc.insets = new Insets(20, 12, 0, 10);
        panel.add(completeButton, gbc);

        return panel;
    }

    private JPanel createTaskPanel() {
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
        text.setBackground(UIManager.getColor("Panel.background"));

        // Add components to the panel
        panel.add(text);

        return panel;
    }

    private JPanel createDueDatePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEADING));

        // Add text to the left of the panel
        JLabel labelDueTime = new JLabel(taskViewModel.DUE_DATE_LABEL);
        labelDueTime.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        labelDueTime.setFont(new Font("Arial", Font.BOLD, 18));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedDateTime = task.getDueDate().format(formatter);
        JLabel dueTime = new JLabel(formattedDateTime);
        dueTime.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
        dueTime.setFont(new Font("Arial", Font.BOLD, 18));

        JLabel newLine = new JLabel(" ");
        newLine.setBorder(BorderFactory.createEmptyBorder(0, 50, 0, 0));
        newLine.setFont(new Font("Arial", Font.BOLD, 18));

        // Add components to the panel
        panel.add(labelDueTime);
        panel.add(dueTime);
        panel.add(newLine);

        return panel;
    }

    private JButton createBackButton() {
        JButton button = new JButton(taskViewModel.GO_BACK_BUTTON_LABEL);
        button.setPreferredSize(new Dimension(100, 30)); // Set the preferred size
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectProjectController.execute(project);
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
                int selectedOption = JOptionPane.showConfirmDialog(null,
                        "Are you sure? Marking task complete will delete the task.",
                        "Choose",
                        JOptionPane.YES_NO_OPTION);
                if (selectedOption == JOptionPane.YES_OPTION) {
                    deleteTaskController.execute(task.getName(), project);
                }
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
        } else if (evt.getPropertyName().equals("message")) {
            String message = (String) evt.getNewValue();
            showMessage(message);
        }
    }
}

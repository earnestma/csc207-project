package view;

import interface_adapter.add_task.AddTaskController;
import interface_adapter.add_task.AddTaskState;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.go_project_view.GoProjectViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class AddTaskView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "add task";
    private final AddTaskViewModel addTaskViewModel;

    final JTextField taskNameInputField = new JTextField(15);
    private final JLabel taskNameErrorField = new JLabel();
    final JTextField dueDateInputField = new JTextField(15);
    private final JLabel dueDateErrorField = new JLabel();

    final JButton cancel;
    final JButton addTask;
    private final AddTaskController addTaskController;
    private final GoProjectViewController goProjectViewController;

    public AddTaskView(AddTaskViewModel addTaskViewModel, AddTaskController controller,
            GoProjectViewController goProjectViewController) {

        this.addTaskController = controller;
        this.goProjectViewController = goProjectViewController;
        this.addTaskViewModel = addTaskViewModel;
        this.addTaskViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Add Task");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel taskNameInfo = new LabelTextPanel(
                new JLabel("Task name:"), taskNameInputField);
        LabelTextPanel dueDateInfo = new LabelTextPanel(
                new JLabel("Due date: (YYYY-MM-DD)"), dueDateInputField);

        JPanel buttons = new JPanel();
        addTask = new JButton(addTaskViewModel.TASK_NAME_LABEL);
        buttons.add(addTask);
        cancel = new JButton(addTaskViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        addTask.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addTask)) {
                            AddTaskState currentState = addTaskViewModel.getState();

                            addTaskController.execute(
                                    currentState.getTaskName(),
                                    currentState.getDueDate(),
                                    currentState.getProject());
                        }
                    }
                });

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(cancel)) {
                            goProjectViewController.execute();
                        }
                    }
                });

        taskNameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                AddTaskState currentState = addTaskViewModel.getState();
                currentState.setTaskName(taskNameInputField.getText() + e.getKeyChar());
                addTaskViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        dueDateInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        AddTaskState currentState = addTaskViewModel.getState();
                        currentState.setDueDate(dueDateInputField.getText() + e.getKeyChar());
                        addTaskViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.add(title);
        this.add(taskNameInfo);
        this.add(taskNameErrorField);
        this.add(dueDateInfo);
        this.add(dueDateErrorField);
        this.add(buttons);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            AddTaskState state = (AddTaskState) evt.getNewValue();
            setFields(state);
        } else if (evt.getPropertyName().equals("message")) {
            String message = (String) evt.getNewValue();
            showMessage(message);
        }
    }

    private void setFields(AddTaskState state) {
        taskNameInputField.setText(state.getTaskName());
        dueDateInputField.setText(state.getDueDate());
    }
}

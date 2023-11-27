package view;

import interface_adapter.add_task.AddTaskController;
import interface_adapter.add_task.AddTaskState;
import interface_adapter.add_task.AddTaskViewModel;

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

    public AddTaskView(AddTaskViewModel addTaskViewModel, AddTaskController controller) {

        this.addTaskController = controller;
        this.addTaskViewModel = addTaskViewModel;
        this.addTaskViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Add Task Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel taskNameInfo = new LabelTextPanel(
                new JLabel("Task name"), taskNameInputField);
        LabelTextPanel dueDateInfo = new LabelTextPanel(
                new JLabel("Due Date"), dueDateInputField);

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
                                    currentState.getDueDate()
                            );
                        }
                    }
                }
        );

        cancel.addActionListener(this);

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

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            AddTaskState state = (AddTaskState) evt.getNewValue();
            setFields(state);
            JOptionPane.showMessageDialog(this, state.showTaskAdded());
        }
    }

    private void setFields(AddTaskState state) {
        taskNameInputField.setText(state.getTaskName());
        dueDateInputField.setText(state.getDueDate());
    }
}

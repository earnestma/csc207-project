package view;

import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.delete_task.DeleteTaskState;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.go_project_view.GoProjectViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeleteTaskView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "delete task";
    private final DeleteTaskViewModel deleteTaskViewModel;

    final JTextField taskNameInputField = new JTextField(15);

    final JButton cancel;
    final JButton deleteTask;
    private final DeleteTaskController deleteTaskController;
    private final GoProjectViewController goProjectViewController;

    public DeleteTaskView(DeleteTaskViewModel deleteTaskViewModel, DeleteTaskController controller,
            GoProjectViewController goProjectViewController) {
        this.deleteTaskController = controller;
        this.goProjectViewController = goProjectViewController;
        this.deleteTaskViewModel = deleteTaskViewModel;
        this.deleteTaskViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Delete Task");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel taskNameInfo = new LabelTextPanel(
                new JLabel("Enter the name of the task to be deleted:"), taskNameInputField);

        JPanel buttons = new JPanel();
        deleteTask = new JButton(deleteTaskViewModel.DELETE_TASK_BUTTON_LABEL);
        buttons.add(deleteTask);
        cancel = new JButton(deleteTaskViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        deleteTask.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteTask)) {
                            DeleteTaskState currentState = deleteTaskViewModel.getState();

                            deleteTaskController.execute(currentState.getTaskName(),
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
                DeleteTaskState currentState = deleteTaskViewModel.getState();
                currentState.setTaskName(taskNameInputField.getText() + e.getKeyChar());
                deleteTaskViewModel.setState(currentState);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(taskNameInfo);
        this.add(buttons);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click" + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            DeleteTaskState state = (DeleteTaskState) evt.getNewValue();
            setFields(state);
        } else if (evt.getPropertyName().equals("message")) {
            String message = (String) evt.getNewValue();
            showMessage(message);
        }
    }

    private void setFields(DeleteTaskState state) {
        taskNameInputField.setText(state.getTaskName());
    }
}

package view;

import interface_adapter.delete_project.DeleteProjectController;
import interface_adapter.delete_project.DeleteProjectState;
import interface_adapter.delete_project.DeleteProjectViewModel;
import interface_adapter.go_home_view.GoHomeViewController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class DeleteProjectView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "delete project";
    private final DeleteProjectViewModel deleteProjectViewModel;

    final JTextField projectNameInputField = new JTextField(15);

    final JButton cancel;
    final JButton deleteProject;
    private final DeleteProjectController deleteProjectController;
    private final GoHomeViewController goHomeViewController;

    public DeleteProjectView(DeleteProjectViewModel deleteProjectViewModel, DeleteProjectController controller,
            GoHomeViewController goHomeViewController) {
        this.deleteProjectController = controller;
        this.goHomeViewController = goHomeViewController;
        this.deleteProjectViewModel = deleteProjectViewModel;
        this.deleteProjectViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Delete Project");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel projectNameInfo = new LabelTextPanel(
                new JLabel("Enter the name of the project to be deleted:"), projectNameInputField);

        JPanel buttons = new JPanel();
        deleteProject = new JButton(deleteProjectViewModel.DELETE_TASK_BUTTON_LABEL);
        buttons.add(deleteProject);
        cancel = new JButton(deleteProjectViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        deleteProject.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(deleteProject)) {
                            DeleteProjectState currentState = deleteProjectViewModel.getState();

                            deleteProjectController.execute(currentState.getProjectName());
                        }
                    }
                });

        cancel.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(cancel)) {
                            goHomeViewController.execute();
                        }
                    }
                });

        projectNameInputField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                DeleteProjectState currentState = deleteProjectViewModel.getState();
                currentState.setProjectName(projectNameInputField.getText() + e.getKeyChar());
                deleteProjectViewModel.setState(currentState);
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
        this.add(projectNameInfo);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click" + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            DeleteProjectState state = (DeleteProjectState) evt.getNewValue();
            setFields(state);
        } else if (evt.getPropertyName().equals("message")) {
            String message = (String) evt.getNewValue();
            showMessage(message);
        }
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    private void setFields(DeleteProjectState state) {
        projectNameInputField.setText(state.getProjectName());
    }
}

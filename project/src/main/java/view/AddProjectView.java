package view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import app.GoHomeViewUseCaseFactory;
import interface_adapter.ViewModelManager;
import interface_adapter.add_project.AddProjectController;
import interface_adapter.add_project.AddProjectState;
import interface_adapter.add_project.AddProjectViewModel;
import interface_adapter.add_task.AddTaskState;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.home_view.HomeViewState;
import interface_adapter.home_view.HomeViewViewModel;

public class AddProjectView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "add project";
    private final AddProjectViewModel addProjectViewModel;

    final JTextField projectNameInputTextField = new JTextField(15);
    private final JLabel projectNameErrorField = new JLabel();

    final JButton cancel;
    final JButton addProject;

    private final AddProjectController addProjectController;
    private final GoProjectViewController goProjectViewController;
    private final GoHomeViewController goHomeViewController;
    private final ViewModelManager ViewModelManager;
    private final HomeViewViewModel homeViewViewModel;

    public AddProjectView(AddProjectViewModel addProjectViewModel, AddProjectController controller,
            GoProjectViewController goProjectViewController, GoHomeViewController goHomeViewController,
            ViewModelManager ViewModelManager, HomeViewViewModel homeViewViewModel) {

        this.addProjectController = controller;
        this.goProjectViewController = goProjectViewController;
        this.addProjectViewModel = addProjectViewModel;
        this.addProjectViewModel.addPropertyChangeListener(this);
        this.goHomeViewController = goHomeViewController;

        this.ViewModelManager = ViewModelManager;
        this.homeViewViewModel = homeViewViewModel;

        JLabel title = new JLabel("Add Project");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel projectNameInfo = new LabelTextPanel(new JLabel("Project Name:"), projectNameInputTextField);

        JPanel buttons = new JPanel();
        addProject = new JButton(addProjectViewModel.PROJECT_NAME_LABEL);

        buttons.add(addProject);

        cancel = new JButton(addProjectViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);

        addProject.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(addProject)) {
                            AddProjectState currentState = addProjectViewModel.getState();

                            try {
                                addProjectController.execute(currentState.getProjectName());
                            } catch (NullPointerException e) { // !?

                            }

                            // goHomeViewController.execute();
                            HomeViewState homeViewState = homeViewViewModel.getState();
                            homeViewViewModel.setState(homeViewState);
                            homeViewViewModel.firePropertyChanged();

                            ViewModelManager.setActiveView(homeViewViewModel.getViewName());
                            ViewModelManager.firePropertyChanged();

                        }
                    }
                });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(cancel)) {
                    goHomeViewController.execute();
                }
            }
        });

        projectNameInputTextField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                AddProjectState currentState = addProjectViewModel.getState();
                currentState.setProjectName(projectNameInputTextField.getText() + e.getKeyChar());
                addProjectViewModel.setState(currentState);
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
        this.add(projectNameErrorField);
        this.add(buttons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click" + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("state")) {
            AddProjectState state = (AddProjectState) evt.getNewValue();
            setFields(state);
        }
    }

    private void setFields(AddProjectState state) {
        projectNameInputTextField.setText(state.getProjectName());
    }

}

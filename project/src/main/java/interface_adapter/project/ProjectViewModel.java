package interface_adapter.project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProjectViewModel extends ViewModel {
    private final String TITLE_LABEL = "Project View";

    private ProjectState state = new ProjectState();

    public static final String PROJECT_VIEW_NAME = "project";
    public static final String HOME_PAGE_BUTTON_LABEL = "Go Back";

    public static final String ADD_TASK_BUTTON_LABEL = "Add Task";

    public static final String DELETE_TASK_BUTTON_LABEL = "Delete Task";

    public ProjectViewModel() {
        super(PROJECT_VIEW_NAME);
    }

    public void setState(ProjectState state) {
        this.state = state;
    }

    public ProjectState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Login Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

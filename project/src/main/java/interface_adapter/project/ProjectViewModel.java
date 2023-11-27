package main.java.interface_adapter.project;

import main.java.interface_adapter.ViewModel;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

import main.java.entity.Task;

public class ProjectViewModel extends ViewModel{
    private final String TITLE_LABEL = "Project View";

    private ProjectState state = new ProjectState();

    public static final String HOME_PAGE_BUTTON_LABEL = "Go Back";

    public static final String ADD_TASK_BUTTON_LABEL = "Add Task";

    private ArrayList<Task> tasks;

    public ProjectViewModel() {
        super("project");
    }

    public void setState(ProjectState state) {
        this.state = state;
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

    public ProjectState getState() {
        return state;
    }

    public ArrayList<Task> getTasksList() {
        return tasks;
    }

    public void setTasksList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }


}

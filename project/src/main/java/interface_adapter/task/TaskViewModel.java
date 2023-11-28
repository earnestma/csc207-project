package interface_adapter.task;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TaskViewModel extends ViewModel {
    private final String TITLE_LABEL = "Task View";
    
    private TaskState state = new TaskState();
    
    public static final String ADD_TASK_BUTTON_LABEL = "Go Back";
    
    public static final String HOME_PAGE_BUTTON_LABEL = "Time";
    
    public static final String COMPLETE_BUTTON_LABEL = "Complete";
    
    public TaskViewModel() {
        super("task");
    }
    
    public void setState(TaskState state) {
        this.state = state;
    }
    
    public TaskState getState(){return state;}
    
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

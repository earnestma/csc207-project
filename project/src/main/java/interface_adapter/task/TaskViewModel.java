package interface_adapter.task;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TaskViewModel extends ViewModel {
    private final String TITLE_LABEL = "Task View";

    private TaskState state = new TaskState();
    private String message;
    public static final String TASK_LABEL = "TASK";
    public static final String DUE_DATE_LABEL = "Due Date:";
    public static final String GO_BACK_BUTTON_LABEL = "Go Back";

    public static final String TIME_BUTTON_LABEL = "Time Left";

    public static final String COMPLETE_BUTTON_LABEL = "Complete";

    public TaskViewModel() {
        super("task");
        this.message = message;
    }

    public void setState(TaskState state) {
        this.state = state;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public TaskState getState() {
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

    public void showMessage() {
        support.firePropertyChange("message", null, this.message);
    }
}

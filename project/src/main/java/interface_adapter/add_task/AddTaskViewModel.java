package interface_adapter.add_task;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class AddTaskViewModel extends ViewModel {

    public final String TITLE_LABEL = "Add Task View";
    public final String TASK_NAME_LABEL = "Confirm";
    public final String DUE_DATE_LABEL = "Enter due date (MM-DD-YYYY)";

    public static final String ADD_TASK_BUTTON_LABEL = "Add task";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private AddTaskState state = new AddTaskState();
    private String message;

    public AddTaskViewModel() {
        super("add task");
        this.message = message;
    }

    public void setState(AddTaskState state) {
        this.state = state;
    }

    public AddTaskState getState() {
        return state;
    }
    public void setMessage(String message) {this.message = message;}
    public void showMessage() {support.firePropertyChange("message", null, this.message);}

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

}

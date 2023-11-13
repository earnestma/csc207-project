package project.src.main.java.interface_adapter.add_task;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class AddTaskViewModel {

    public final String TITLE_LABEL = "Add Task View";
    public final String TASK_NAME_LABEL = "Enter task name:";
    public final String DUE_DATE_LABEL = "Enter due date (MM-DD-YYYY)";

    public static final String ADD_TASK_BUTTON_LABEL = "Add task";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private AddTaskState state = new AddTaskState();

    public AddTaskViewModel(){
        super("add task");
    }

    public void setState(AddTaskState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
}

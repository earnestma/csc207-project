package interface_adapter.delete_task;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteTaskViewModel extends ViewModel {

    public final String TITLE_LABEL = "Delete Task View";
    public final String DELETING_TASK = "Select which task to delete:";
    public static final String DELETE_TASK_BUTTON_LABEL = "Confirm";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private String message;

    private DeleteTaskState state = new DeleteTaskState();

    public DeleteTaskViewModel() {
        super("delete task");
        this.message = message;
    }

    public void setState(DeleteTaskState state) {
        this.state = state;
    }

    public DeleteTaskState getState() {
        return state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void showMessage() {
        support.firePropertyChange("message", null, this.message);
    }

}

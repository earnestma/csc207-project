package interface_adapter.delete_task;

import interface_adapter.ViewModel;
import org.json.Property;

import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class DeleteTaskViewModel extends ViewModel {

    public final String TITLE_LABEL = "Delete Task View";
    public final String DELETING_TASK = "Select which task to delete:";
    public static final String DELETE_TASK_BUTTON_LABEL = "Confirm";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private DeleteTaskState state = new DeleteTaskState();

    public DeleteTaskViewModel() {
        super("delete task");
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

}

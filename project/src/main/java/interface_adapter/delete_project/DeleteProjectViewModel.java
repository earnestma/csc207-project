package interface_adapter.delete_project;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class DeleteProjectViewModel extends ViewModel {

    public final String TITLE_LABEL = "Delete Project View";
    public final String DELETING_TASK = "Select which project to delete:";
    public static final String DELETE_TASK_BUTTON_LABEL = "Confirm";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private DeleteProjectState state = new DeleteProjectState();

    private String message;

    public DeleteProjectViewModel() {
        super("delete project");
        this.message = message;
    }

    public void setState(DeleteProjectState state) {
        this.state = state;
    }

    public DeleteProjectState getState() {
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

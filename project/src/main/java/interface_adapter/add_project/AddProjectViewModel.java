package interface_adapter.add_project;

import interface_adapter.ViewModel;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class AddProjectViewModel extends ViewModel {
    public final String TITLE_LABEL = "Add Project View";
    public final String PROJECT_NAME_LABEL = "Confirm";

    public static final String ADD_PROJECT_BUTTON_LABEL = "Add Project";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";

    private AddProjectState state = new AddProjectState();

    public AddProjectViewModel() {
        super("add project");
    }

    public void setState(AddProjectState state) {
        this.state = state;
    }

    public AddProjectState getState() {
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

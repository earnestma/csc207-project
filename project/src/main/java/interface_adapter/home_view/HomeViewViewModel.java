package interface_adapter.home_view;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HomeViewViewModel extends ViewModel{
    private final String TITLE_LABEL = "Home View";

    private HomeViewState state = new HomeViewState();
    
    public static final String HOME_VIEW_NAME = "home view";

    public static final String ADD_PROJECT_BUTTON_LABEL = "Add Project";

    public static final String DELETE_PROJECT_BUTTON_LABEL = "Delete Project";

    public static final String PROJECTS_LABEL = "Projects: ";

    public HomeViewViewModel() {super(HOME_VIEW_NAME);}

    public void setState(HomeViewState state) {this.state = state;}

    public HomeViewState getState() {return state;}

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

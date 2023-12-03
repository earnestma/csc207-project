package interface_adapter.add_project;

import entity.User;
import entity.Project;

public class AddProjectState {

    private String projectName = "";
    private String projectNameError = null;
    private User user;

    public AddProjectState(AddProjectState copy) {
        projectName = copy.projectName;
        projectNameError = copy.projectNameError;

        user = copy.user;
    }

    public AddProjectState() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String n) {
        this.projectName = n;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

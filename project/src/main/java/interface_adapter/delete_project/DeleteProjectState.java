package interface_adapter.delete_project;

import entity.User;

public class DeleteProjectState {
    private String projectName = "";
    private User user;

    public DeleteProjectState(DeleteProjectState copy) {
        projectName = copy.projectName;
        user = copy.user;
    }

    public DeleteProjectState() {}

    public String getProjectName() {
        return projectName;
    }

    public User getUser() {
        return user;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

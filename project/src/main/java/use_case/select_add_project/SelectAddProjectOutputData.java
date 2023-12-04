package use_case.select_add_project;

import entity.Project;
import entity.User;

public class SelectAddProjectOutputData {
    private final User user;
    private Project project;

    public SelectAddProjectOutputData(User user) {
        this.user = user;
        this.project = new Project("");
    }

    public User getUser() {
        return user;
    }
}

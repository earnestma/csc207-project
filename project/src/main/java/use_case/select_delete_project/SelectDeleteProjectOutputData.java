package use_case.select_delete_project;

import entity.User;

public class SelectDeleteProjectOutputData {
    private final User user;

    public SelectDeleteProjectOutputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

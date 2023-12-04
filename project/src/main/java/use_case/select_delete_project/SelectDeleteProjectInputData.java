package use_case.select_delete_project;

import entity.User;

public class SelectDeleteProjectInputData {
    final private User user;

    public SelectDeleteProjectInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

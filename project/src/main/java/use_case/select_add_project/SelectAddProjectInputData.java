package use_case.select_add_project;

import entity.User;

public class SelectAddProjectInputData {
    final private User user;

    public SelectAddProjectInputData(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}

package use_case.delete_project;

import entity.User;

public class DeleteProjectInputData {
    final private String projectName;
    final private User user;

    public DeleteProjectInputData(String projectName, User user) {
        this.projectName = projectName;
        this.user = user;
    }

    public String getProjectName () {
        return projectName;
    }
     User getUser() {
        return user;
    }
}


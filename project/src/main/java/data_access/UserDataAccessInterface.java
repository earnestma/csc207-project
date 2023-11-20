package data_access;

import entity.Project;

public interface UserDataAccessInterface {
    String getTodoistAPIKey();

    void addProject(Project project);

    void deleteProject(Project project);
}

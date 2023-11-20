package data_access;

import java.io.IOException;

import entity.Project;

public interface UserDataAccessInterface {
    void addProject(Project project) throws IOException;

    void deleteProject(Project project);
}

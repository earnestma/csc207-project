package data_access;

import entity.Project;

import java.io.IOException;
import java.util.ArrayList;

public interface UserDataAccessInterface {
    void addProject(Project project) throws IOException;

    ArrayList<Project> listProjects();

    void deleteProject(Project project);
}

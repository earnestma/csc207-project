package data_access;

import java.io.IOException;
import java.util.ArrayList;

import entity.Project;

public interface UserDataAccessInterface {
    void addProject(Project project) throws IOException;

    ArrayList<Project> listProjects();

    void deleteProject(Project project);
}

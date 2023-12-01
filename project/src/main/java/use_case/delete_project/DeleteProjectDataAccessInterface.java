package use_case.delete_project;

import entity.Project;

import java.util.ArrayList;

public interface DeleteProjectDataAccessInterface {
    void deleteProject(Project project);
    ArrayList<Project> getProjects(long userId);
}

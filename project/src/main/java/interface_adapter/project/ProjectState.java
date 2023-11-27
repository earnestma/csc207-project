package main.java.interface_adapter.project;

import main.java.entity.*;
import java.util.*;

public class ProjectState {
    private String projectName = "";
    private Project project;

    public ProjectState(ProjectState copy) {
        projectName = copy.projectName;
        project = copy.project;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ProjectState() {
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String username) {
        this.projectName = projectName;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

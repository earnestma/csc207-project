package main.java.interface_adapter.project;

import main.java.entity.*;
import java.util.*;

public class ProjectState {
    private Project project;

    public ProjectState(ProjectState copy) {
        project = copy.project;
    }

    // Because of the previous copy constructor, the default constructor must be explicit.
    public ProjectState() {
    }
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}

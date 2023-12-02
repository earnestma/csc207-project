package use_case.delete_project;

import entity.Project;

import java.util.ArrayList;

public class DeleteProjectOutputData {
    private ArrayList<Project> projectList;
    private final boolean useCaseFailed;

    public DeleteProjectOutputData(ArrayList<Project> projectList, boolean useCaseFailed) {
        this.projectList = projectList;
        this.useCaseFailed = useCaseFailed;
    }

    public ArrayList<Project> getProjectList() {
        return projectList;
    }
}
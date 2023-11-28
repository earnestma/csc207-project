package use_case.select_project;

import entity.Project;

public class SelectProjectOutputData {
    private final Project project;
    
    public SelectProjectOutputData(Project project){
        this.project = project;
    }
    
    public Project getProject(){return project;}
}

package main.java.use_case.select_project;

import main.java.entity.Project;

public class SelectProjectOutputData {
    private final Project project;
    
    private boolean useCaseFailed;
    
    public SelectProjectOutputData(Project project){
        this.project = project;
    }
    
    public Project getProject(){return project;}
}

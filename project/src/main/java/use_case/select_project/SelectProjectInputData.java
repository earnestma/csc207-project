package use_case.select_project;

import entity.Project;

public class SelectProjectInputData {
    final private Project project;
    
    public SelectProjectInputData(Project project){
        this.project = project;
    }
    
    public Project getProject(){return project;}
}

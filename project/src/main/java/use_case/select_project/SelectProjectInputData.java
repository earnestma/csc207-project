package main.java.use_case.select_project;

import main.java.entity.Project;

public class SelectProjectInputData {
    final private Project project;
    
    public SelectProjectInputData(Project project){
        this.project = project;
    }
    
    public Project getProject(){return project;}
}

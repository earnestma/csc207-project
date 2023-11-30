package use_case.select_project;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public class SelectProjectOutputData {
    private final Project project;
    private final ArrayList<Task> taskList;
    
    private boolean useCaseFailed;
    
    public SelectProjectOutputData(Project project, ArrayList<Task> taskList){
        this.project = project;
        this.taskList = taskList;
    }
    
    public Project getProject(){
        return project;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}

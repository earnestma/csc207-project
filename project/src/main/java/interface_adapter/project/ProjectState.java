package interface_adapter.project;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public class ProjectState {
    private Project project;
    private ArrayList<Task> taskList;

    public ProjectState(ProjectState copy) {
        project = copy.project;
        taskList = copy.taskList;
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

    public void setTaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}

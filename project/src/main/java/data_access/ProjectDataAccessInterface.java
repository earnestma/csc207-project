package data_access;

import entity.Task;
import entity.Project;

import java.util.ArrayList;

public interface ProjectDataAccessInterface {
    void modifyProject(Project project);

    ArrayList<Task> getTasks(int projectID);

    void addTask(Project project, Task task);

    void deleteTask(Task task);

    void modifyTask(Project project, Task task);
}

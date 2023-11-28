package data_access;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public interface ProjectDataAccessInterface {
    void modifyProject(Project project);

    ArrayList<Task> getTasks(long projectID);

    void addTask(Project project, Task task);

    void deleteTask(Task task);

    void modifyTask(Project project, Task task);
}

package data_access;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public interface ProjectDataAccessInterface {

    ArrayList<Task> getTasks(long projectID);

    void addTask(Project project, Task task);

    void deleteTask(Task task);
}

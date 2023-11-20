package data_access;

import entity.Task;
import entity.User;
import entity.Project;

public interface ProjectDataAccessInterface {
    void modifyProject(Project project);

    boolean addTask(Task task);

    boolean deleteTask(Task task);

}

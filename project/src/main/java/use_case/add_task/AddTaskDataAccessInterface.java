package use_case.add_task;

import entity.Project;
import entity.Task;

import java.util.ArrayList;

public interface AddTaskDataAccessInterface {
    void addTask(Project project, Task task);

    ArrayList<Task> getTasks(long projectID);
}

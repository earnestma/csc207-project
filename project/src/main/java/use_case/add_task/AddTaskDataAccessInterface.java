package use_case.add_task;

import entity.*;

public interface AddTaskDataAccessInterface {
    void addTask(Project project, Task task);
}

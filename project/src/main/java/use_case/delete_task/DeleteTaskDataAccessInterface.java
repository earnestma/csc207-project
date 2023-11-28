package use_case.delete_task;

import entity.Task;

import java.util.ArrayList;

public interface DeleteTaskDataAccessInterface {
    void deleteTask(Task task);

    ArrayList<Task> getTasks(long projectID);
}

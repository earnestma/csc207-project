package use_case.mark_task_complete;

import entity.Task;

public interface MarkTaskCompleteDataAccessInterface {
    Task getTask(int taskId);

    void updateTask(Task task);
}

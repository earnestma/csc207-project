package use_case.mark_task_complete;

import entity.Task;

public class MarkTaskCompleteInputData {

    final private Task task;

    public MarkTaskCompleteInputData(Task task) {
        this.task = task;
    }

    public Task getTask() {
        return task;
    }
}

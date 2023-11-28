package use_case.mark_task_complete;

import entity.Task;

public class MarkTaskCompleteOutputData {
    private final Task task;
    private boolean useCaseFailed;

    public MarkTaskCompleteOutputData(Task task, boolean useCaseFailed) {
        this.task = task;
        this.useCaseFailed = useCaseFailed;
    }

    public Task getTask() {
        return task;
    }
}

package interface_adapter.mark_task_complete;

import entity.Task;
import use_case.mark_task_complete.MarkTaskCompleteInputBoundary;
import use_case.mark_task_complete.MarkTaskCompleteInputData;

public class MarkTaskCompleteController {

    final MarkTaskCompleteInputBoundary markTaskCompleteInteractor;

    public MarkTaskCompleteController(MarkTaskCompleteInputBoundary markTaskCompleteInteractor) {
        this.markTaskCompleteInteractor = markTaskCompleteInteractor;
    }

    public void execute(Task task) {
        MarkTaskCompleteInputData markTaskCompleteInputData = new MarkTaskCompleteInputData(task);
        markTaskCompleteInteractor.execute(markTaskCompleteInputData);
    }
}

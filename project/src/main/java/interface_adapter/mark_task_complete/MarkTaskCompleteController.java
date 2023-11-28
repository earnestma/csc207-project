package interface_adapter.mark_task_complete;

import use_case.mark_task_complete.*;
public class MarkTaskCompleteController {

    final MarkTaskCompleteInputBoundary markTaskCompleteUseCaseInteractor;

    public MarkTaskCompleteController(MarkTaskCompleteInputBoundary markTaskCompleteUseCaseInteractor) {
        this.markTaskCompleteUseCaseInteractor = markTaskCompleteUseCaseInteractor;
    }

    public void execute() {
        MarkTaskCompleteInteractor.execute();
    }
}

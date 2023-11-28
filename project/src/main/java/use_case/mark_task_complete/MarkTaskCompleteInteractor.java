package use_case.mark_task_complete;

import entity.Task;

public class MarkTaskCompleteInteractor implements MarkTaskCompleteInputBoundary {
    final MarkTaskCompleteOutputBoundary markTaskCompletePresenter;

    public MarkTaskCompleteInteractor(MarkTaskCompleteOutputBoundary markTaskCompleteOutputBoundary) {
        this.markTaskCompletePresenter = markTaskCompleteOutputBoundary;
    }

    @Override
    public void execute(MarkTaskCompleteInputData markTaskCompleteInputData) {
        Task task = markTaskCompleteInputData.getTask();
        if (task != null) {
            task.markAsCompleted();
            MarkTaskCompleteOutputData markTaskCompleteOutputData = new MarkTaskCompleteOutputData(task, false);
            markTaskCompletePresenter.prepareSuccessView(markTaskCompleteOutputData);
        }
    }
}
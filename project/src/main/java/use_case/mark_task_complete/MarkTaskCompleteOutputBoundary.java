package use_case.mark_task_complete;

public interface MarkTaskCompleteOutputBoundary {
    void prepareSuccessView(MarkTaskCompleteOutputData task);
    void prepareFailView(String error);
}

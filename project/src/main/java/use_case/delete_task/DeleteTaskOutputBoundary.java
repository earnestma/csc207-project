package use_case.delete_task;

public interface DeleteTaskOutputBoundary {
    void prepareSuccessView(DeleteTaskOutputData deletedTask);

    void prepareFailView(String message);
}

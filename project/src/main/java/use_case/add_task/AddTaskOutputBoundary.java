package use_case.add_task;

public interface AddTaskOutputBoundary {
    void prepareSuccessView(AddTaskOutputData task);

    void prepareFailView(String error);
}

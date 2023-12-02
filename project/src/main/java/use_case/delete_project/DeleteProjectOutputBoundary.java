package use_case.delete_project;

public interface DeleteProjectOutputBoundary {
    void prepareSuccessView(DeleteProjectOutputData deleteProjectOutputData);
    void prepareFailView(String error);
}

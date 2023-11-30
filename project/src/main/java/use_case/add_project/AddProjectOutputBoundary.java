package use_case.add_project;

public interface AddProjectOutputBoundary {
    void prepareSuccessView(AddProjectOutputData project);

    void prepareFailView(String error);
}

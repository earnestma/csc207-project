package use_case.delete_project;

public class DeleteProjectOutputData {
    private final boolean useCaseFailed;

    public DeleteProjectOutputData(boolean useCaseFailed) {
        this.useCaseFailed = useCaseFailed;
    }
}
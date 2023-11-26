package main.java.use_case.add_project;

public class AddProjectOutputData {

    private final String projectName;
    private boolean useCaseFailed;

    public AddProjectOutputData(String projectName, boolean useCaseFailed) {
        this.projectName = projectName;
        this.useCaseFailed = useCaseFailed;
    }

    public String getProjectName() {
        return projectName;
    }

}

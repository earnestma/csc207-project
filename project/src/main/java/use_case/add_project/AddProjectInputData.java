package use_case.add_project;

public class AddProjectInputData {
    final private String projectName;

    public AddProjectInputData(String projectName) {
        this.projectName = projectName;
    }

    String getProjectName() {
        return projectName;
    }
}

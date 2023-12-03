package use_case.delete_project;

public class DeleteProjectInputData {
    final private String projectName;

    public DeleteProjectInputData(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName () {
        return projectName;
    }
}


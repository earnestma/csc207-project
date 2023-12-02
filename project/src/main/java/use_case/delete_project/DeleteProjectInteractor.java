package use_case.delete_project;

import entity.Project;

import java.util.ArrayList;

public class DeleteProjectInteractor implements DeleteProjectInputBoundary {
    final DeleteProjectDataAccessInterface userDataAccessObject;
    final DeleteProjectOutputBoundary deleteProjectPresenter;

    public DeleteProjectInteractor(DeleteProjectDataAccessInterface deleteProjectDataAccessInterface,
                                   DeleteProjectOutputBoundary deleteProjectOutputBoundary) {
        this.userDataAccessObject = deleteProjectDataAccessInterface;
        this.deleteProjectPresenter = deleteProjectOutputBoundary;
    }

    public void execute(DeleteProjectInputData deleteProjectInputData) {
        ArrayList<Project> projectList = this.userDataAccessObject.listProjects();

        String projectName = deleteProjectInputData.getProjectName();

        Project foundProject = null;
        for (Project project: projectList) {
            if (project.getName().equals(projectName)) {
                foundProject = project;
                projectList.remove(project);
                break;
            }
        }

        userDataAccessObject.deleteProject(foundProject);

        DeleteProjectOutputData deleteProjectOutputData = new DeleteProjectOutputData(projectList, false);
        deleteProjectPresenter.prepareSuccessView(deleteProjectOutputData);
    }
}

package use_case.delete_project;

import entity.Project;
import entity.Task;
import use_case.delete_task.DeleteTaskOutputData;

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
        long userId = deleteProjectInputData.getUser().getId();
        ArrayList<Project> projectList = this.userDataAccessObject.getProjects(userId);

        String projectName = deleteProjectInputData.getProjectName();

        Project foundProject = null;
        for (Project project: projectList) {
            if (project.getName().equals(projectName)) {
                foundProject = project;
                break;
            }
        }

        userDataAccessObject.deleteProject(foundProject);

        DeleteProjectOutputData deleteProjectOutputData = new DeleteProjectOutputData(false);
        deleteProjectPresenter.prepareSuccessView(deleteProjectOutputData);
    }
}


    }
}

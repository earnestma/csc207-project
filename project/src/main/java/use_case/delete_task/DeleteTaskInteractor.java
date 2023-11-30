package use_case.delete_task;

import entity.Task;

import java.util.ArrayList;

public class DeleteTaskInteractor implements DeleteTaskInputBoundary {
    final DeleteTaskDataAccessInterface projectDataAccessObject;
    final DeleteTaskOutputBoundary deleteTaskPresenter;

    public DeleteTaskInteractor(DeleteTaskDataAccessInterface deleteTaskDataAccessInterface,
                                DeleteTaskOutputBoundary deleteTaskOutputBoundary) {
        this.projectDataAccessObject = deleteTaskDataAccessInterface;
        this.deleteTaskPresenter = deleteTaskOutputBoundary;
    }

    public void execute(DeleteTaskInputData deleteTaskInputData) {
        long projectID = deleteTaskInputData.getProject().getId();
        ArrayList<Task> taskList = this.projectDataAccessObject.getTasks(projectID);

        String taskName = deleteTaskInputData.getTaskName();

        Task foundTask = null;
        for (Task task: taskList) {
            if (task.getName().equals(taskName)) {
                foundTask = task;
                break;
            }
        }

        projectDataAccessObject.deleteTask(foundTask);

        DeleteTaskOutputData deleteTaskOutputData = new DeleteTaskOutputData(false);
        deleteTaskPresenter.prepareSuccessView(deleteTaskOutputData);
    }
}

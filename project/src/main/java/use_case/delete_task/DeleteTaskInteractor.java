package use_case.delete_task;

import entity.Task;

import java.util.ArrayList;

public class DeleteTaskInteractor implements DeleteTaskInputBoundary {
    final DeleteTaskDataAccessInterface projectDataAccessObject;
    final DeleteTaskOutputBoundary deleteTaskPresenter;
    final ArrayList<Task> taskList;

    public DeleteTaskInteractor(DeleteTaskDataAccessInterface deleteTaskDataAccessInterface,
                                DeleteTaskOutputBoundary deleteTaskOutputBoundary,
                                DeleteTaskInputData deleteTaskInputData) {
        this.projectDataAccessObject = deleteTaskDataAccessInterface;
        this.deleteTaskPresenter = deleteTaskOutputBoundary;

        long projectID = deleteTaskInputData.getProject().getId();
        this.taskList = deleteTaskDataAccessInterface.getTasks(projectID);
    }

    public void execute(DeleteTaskInputData deleteTaskInputData) {

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

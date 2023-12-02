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
        try {
            long projectID = deleteTaskInputData.getProject().getId();
            ArrayList<Task> taskList = this.projectDataAccessObject.getTasks(projectID);

            String taskName = deleteTaskInputData.getTaskName();

            Task foundTask = null;
            for (Task task : taskList) {
                if (task.getName().equals(taskName)) {
                    foundTask = task;
                    taskList.remove(task);
                    break;
                }
            }

            projectDataAccessObject.deleteTask(foundTask);

            DeleteTaskOutputData deleteTaskOutputData = new DeleteTaskOutputData(taskList, false);
            deleteTaskPresenter.prepareSuccessView(deleteTaskOutputData);
        } catch (NullPointerException e){
            deleteTaskPresenter.prepareFailView("Task does not exist");
        }
    }
}

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

            ArrayList<String> taskNameList = new ArrayList<>();
            for (Task task1 : taskList) {
                taskNameList.add(task1.getName());
            }

            if (taskNameList.contains(taskName)) {
                int index = taskNameList.indexOf(taskName);
                Task foundTask = taskList.get(index);
                taskList.remove(index);
                projectDataAccessObject.deleteTask(foundTask);
            }
      
            else{
                deleteTaskPresenter.prepareFailView("Task does not exist");
            }

            DeleteTaskOutputData deleteTaskOutputData = new DeleteTaskOutputData(taskList, false);
            deleteTaskPresenter.prepareSuccessView(deleteTaskOutputData);
    }
}

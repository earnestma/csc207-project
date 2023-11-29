package use_case.add_task;

import entity.Project;
import entity.Task;
import entity.TaskFactory;

public class AddTaskInteractor implements AddTaskInputBoundary {
    final AddTaskDataAccessInterface userDataAccessObject;
    final AddTaskOutputBoundary addTaskPresenter;
    final TaskFactory taskFactory;

    public AddTaskInteractor(AddTaskDataAccessInterface addTaskDataAccessInterface,
            AddTaskOutputBoundary addTaskOutputBoundary,
            TaskFactory taskFactory) {
        this.userDataAccessObject = addTaskDataAccessInterface;
        this.addTaskPresenter = addTaskOutputBoundary;
        this.taskFactory = taskFactory;
    }

    @Override
    public void execute(AddTaskInputData addTaskInputData) {
        Task task = taskFactory.create(addTaskInputData.getTaskName(), addTaskInputData.getDueDate());
        Project project = addTaskInputData.getProject();
        userDataAccessObject.addTask(project, task);

        AddTaskOutputData addTaskOutputData = new AddTaskOutputData(task.getName(), task.getDueDate(), false);
        addTaskPresenter.prepareSuccessView(addTaskOutputData);
    }
}

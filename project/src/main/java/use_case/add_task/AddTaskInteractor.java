package project.src.main.java.use_case.add_task;
import project.src.main.java.entity.Task;
import project.src.main.java.entity.TaskFactory;

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
        userDataAccessObject.add(task);

        AddTaskOutputData addTaskOutputData = new AddTaskOutputData(task.getName(), task.getDueDate(), false);
        addTaskPresenter.prepareSuccessView(addTaskOutputData);
    }
}

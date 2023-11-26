package project.src.main.java.interface_adapter.add_task;

import project.src.main.java.use_case.add_task.AddTaskInputData;
import project.src.main.java.use_case.add_task.AddTaskInputBoundary;

public class AddTaskController {

    final AddTaskInputBoundary addTaskUseCaseInteractor;
    public AddTaskController(AddTaskInputBoundary addTaskUseCaseInteractor) {
        this.addTaskUseCaseInteractor = addTaskUseCaseInteractor;
    }

    public void execute(String taskName, String dueDate) {
        AddTaskInputData addTaskInputData = new AddTaskInputData(
                taskName, dueDate);

        addTaskUseCaseInteractor.execute(addTaskInputData);
    }
}

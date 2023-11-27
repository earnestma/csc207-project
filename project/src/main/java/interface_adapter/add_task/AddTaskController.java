package interface_adapter.add_task;

import use_case.add_task.*;

public class AddTaskController {

    final AddTaskInputBoundary addTaskUseCaseInteractor;
    public AddTaskController(AddTaskInputBoundary addTaskUseCaseInteractor) {
        this.addTaskUseCaseInteractor = addTaskUseCaseInteractor;
    }

    public void execute(String taskName, String priority, String dueDate) {
        AddTaskInputData addTaskInputData = new AddTaskInputData(
                taskName, priority, dueDate);

        addTaskUseCaseInteractor.execute(addTaskInputData);
    }
}

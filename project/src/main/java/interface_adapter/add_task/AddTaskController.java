package interface_adapter.add_task;

import entity.Project;
import use_case.add_task.*;

public class AddTaskController {

    final AddTaskInputBoundary addTaskUseCaseInteractor;
    public AddTaskController(AddTaskInputBoundary addTaskUseCaseInteractor) {
        this.addTaskUseCaseInteractor = addTaskUseCaseInteractor;
    }

    public void execute(String taskName, String priority, String dueDate, Project project) {
        AddTaskInputData addTaskInputData = new AddTaskInputData(
                taskName, priority, dueDate, project);

        addTaskUseCaseInteractor.execute(addTaskInputData);
    }
}

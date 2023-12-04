package app;

import entity.TaskFactory;
import interface_adapter.ViewModelManager;
import interface_adapter.add_task.AddTaskController;
import interface_adapter.add_task.AddTaskPresenter;
import interface_adapter.add_task.AddTaskViewModel;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.project.ProjectViewModel;
import use_case.add_task.AddTaskDataAccessInterface;
import use_case.add_task.AddTaskInputBoundary;
import use_case.add_task.AddTaskInteractor;
import use_case.add_task.AddTaskOutputBoundary;
import view.AddTaskView;

import java.io.IOException;

public class AddTaskUseCaseFactory {
    private AddTaskUseCaseFactory() {
    }

    public static AddTaskView create(
            ViewModelManager viewModelManager, ProjectViewModel projectViewModel, AddTaskViewModel addTaskViewModel,
            AddTaskDataAccessInterface addTaskDataAccessObject, GoProjectViewController goProjectViewController) {

        try {
            AddTaskController addTaskController = addTaskUseCase(viewModelManager, projectViewModel, addTaskViewModel,
                    addTaskDataAccessObject);
            return new AddTaskView(addTaskViewModel, addTaskController, goProjectViewController);
        } catch (IOException e) {
        }

        return null;
    }

    private static AddTaskController addTaskUseCase(ViewModelManager viewModelManager,
            ProjectViewModel projectViewModel, AddTaskViewModel addTaskViewModel,
            AddTaskDataAccessInterface addTaskDataAccessObject) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        AddTaskOutputBoundary addTaskOutputBoundary = new AddTaskPresenter(viewModelManager, addTaskViewModel,
                projectViewModel);

        TaskFactory taskFactory = new TaskFactory();

        AddTaskInputBoundary addTaskInteractor = new AddTaskInteractor(
                addTaskDataAccessObject, addTaskOutputBoundary, taskFactory);

        return new AddTaskController(addTaskInteractor);
    }
}

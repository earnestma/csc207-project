package app;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_task.DeleteTaskController;
import interface_adapter.delete_task.DeleteTaskViewModel;
import interface_adapter.delete_task.DeleteTaskPresenter;
import interface_adapter.go_project_view.GoProjectViewController;
import interface_adapter.project.ProjectViewModel;
import use_case.delete_task.DeleteTaskDataAccessInterface;
import use_case.delete_task.DeleteTaskInputBoundary;
import use_case.delete_task.DeleteTaskInteractor;
import use_case.delete_task.DeleteTaskOutputBoundary;
import view.DeleteTaskView;

import java.io.IOException;

public class DeleteTaskUseCaseFactory {
    private DeleteTaskUseCaseFactory() {}

    public static DeleteTaskView create(
            ViewModelManager viewModelManager, ProjectViewModel projectViewModel,
            DeleteTaskViewModel deleteTaskViewModel,
            DeleteTaskDataAccessInterface deleteTaskDataAccessInterface,
            GoProjectViewController goProjectViewController) {

        try {
            DeleteTaskController deleteTaskController = deleteTaskUseCase(
                    viewModelManager, projectViewModel, deleteTaskViewModel, deleteTaskDataAccessInterface);
            return new DeleteTaskView(deleteTaskViewModel, deleteTaskController, goProjectViewController);
        } catch (IOException e) {
        }
        return null;
    }

    private static DeleteTaskController deleteTaskUseCase(ViewModelManager viewModelManager, ProjectViewModel projectViewModel,
                                                          DeleteTaskViewModel deleteTaskViewModel,
                                                          DeleteTaskDataAccessInterface deleteTaskDataAccessInterface) throws IOException {
        DeleteTaskOutputBoundary deleteTaskOutputBoundary = new DeleteTaskPresenter(viewModelManager, deleteTaskViewModel, projectViewModel);

        DeleteTaskInputBoundary deleteTaskInteractor = new DeleteTaskInteractor(deleteTaskDataAccessInterface, deleteTaskOutputBoundary);

        return new DeleteTaskController(deleteTaskInteractor);
    }

}

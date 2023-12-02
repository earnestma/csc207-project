package app;

import interface_adapter.ViewModelManager;
import interface_adapter.delete_project.DeleteProjectController;
import interface_adapter.delete_project.DeleteProjectViewModel;
import interface_adapter.delete_project.DeleteProjectPresenter;
import interface_adapter.go_home_view.GoHomeViewController;
import interface_adapter.home_view.HomeViewViewModel;
import use_case.delete_project.DeleteProjectDataAccessInterface;
import use_case.delete_project.DeleteProjectInputBoundary;
import use_case.delete_project.DeleteProjectInteractor;
import use_case.delete_project.DeleteProjectOutputBoundary;
import view.DeleteProjectView;

import java.io.IOException;

public class DeleteProjectUseCaseFactory {
    private DeleteProjectUseCaseFactory() {}

    public static DeleteProjectView create(
            ViewModelManager viewModelManager, HomeViewViewModel homeViewViewModel,
            DeleteProjectViewModel deleteProjectViewModel,
            DeleteProjectDataAccessInterface deleteProjectDataAccessInterface,
            GoHomeViewController goHomeViewController) {

        try {
            DeleteProjectController deleteProjectController = deleteProjectUseCase(
                    viewModelManager, homeViewViewModel, deleteProjectViewModel, deleteProjectDataAccessInterface);
            return new DeleteProjectView(deleteProjectViewModel, deleteProjectController, goHomeViewController);
        } catch (IOException e) {
        }
        return null;
    }

    public static DeleteProjectController deleteProjectUseCase(ViewModelManager viewModelManager, HomeViewViewModel homeViewViewModel,
                                                          DeleteProjectViewModel deleteProjectViewModel,
                                                          DeleteProjectDataAccessInterface deleteProjectDataAccessInterface) throws IOException {
        DeleteProjectOutputBoundary deleteProjectOutputBoundary = new DeleteProjectPresenter(viewModelManager, deleteProjectViewModel, homeViewViewModel);

        DeleteProjectInputBoundary deleteProjectInteractor = new DeleteProjectInteractor(deleteProjectDataAccessInterface, deleteProjectOutputBoundary);

        return new DeleteProjectController(deleteProjectInteractor);
    }

}

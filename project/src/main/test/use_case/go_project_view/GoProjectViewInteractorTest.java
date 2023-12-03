package use_case.go_project_view;

import interface_adapter.project.ProjectViewModel;
import junit.framework.TestCase;

public class GoProjectViewInteractorTest extends TestCase {

    public void testExecute() {
        String viewName = ProjectViewModel.PROJECT_VIEW_NAME;
        GoProjectViewOutputBoundary successPresenter = new GoProjectViewOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assertEquals(viewName, "project");
            }
        };

        GoProjectViewInputBoundary interactor = new GoProjectViewInteractor(successPresenter);
        interactor.execute();
    }
}
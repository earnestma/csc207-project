package use_case.go_project_view;

import junit.framework.TestCase;

public class GoProjectViewInteractorTest extends TestCase {

    public void testExecute() {
        GoProjectViewOutputBoundary successPresenter = new GoProjectViewOutputBoundary() {
            @Override
            public void prepareSuccessView() {
            }
        };

        GoProjectViewInputBoundary interactor = new GoProjectViewInteractor(successPresenter);
        interactor.execute();
    }
}
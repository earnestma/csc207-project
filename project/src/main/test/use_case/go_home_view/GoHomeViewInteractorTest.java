package use_case.go_home_view;

import interface_adapter.home_view.HomeViewViewModel;
import junit.framework.TestCase;

public class GoHomeViewInteractorTest extends TestCase {
    public void testExecute() {
        String actualViewName = HomeViewViewModel.HOME_VIEW_NAME;
        GoHomeViewOutputBoundary successPresenter = new GoHomeViewOutputBoundary() {
            @Override
            public void prepareSuccessView() {
                assertEquals(actualViewName, "home view");
            }
        };
        
        GoHomeViewInputBoundary interactor = new GoHomeViewInteractor(successPresenter);
        interactor.execute();
    }
}

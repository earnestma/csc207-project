package use_case.select_add_project;

import entity.User;
import junit.framework.TestCase;

public class SelectAddProjectInteractorTest extends TestCase {

    public void testExecute() {

        User user = new User("Daniel", "daniel12581", "123456");
        SelectAddProjectInputData inputData = new SelectAddProjectInputData(user);

        SelectAddProjectOutputBoundary successPresenter = new SelectAddProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectAddProjectOutputData response) {
                assertEquals(user, response.getUser());
            }
        };

        SelectAddProjectInputBoundary interactor = new SelectAddProjectInteractor(successPresenter);
        interactor.execute(inputData);
    }
}
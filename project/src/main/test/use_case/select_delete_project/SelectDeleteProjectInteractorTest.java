package use_case.select_delete_project;

import data_access.UserDataAccessInterface;
import data_access.UserDataAccessObject;
import entity.User;
import junit.framework.TestCase;

public class SelectDeleteProjectInteractorTest extends TestCase {
    public void testExecute() {

        UserDataAccessInterface userRepository = new UserDataAccessObject();

        User user = new User("Daniel", "daniel12581", "123456");
        SelectDeleteProjectInputData inputData = new SelectDeleteProjectInputData(user);

        SelectDeleteProjectOutputBoundary successPresenter = new SelectDeleteProjectOutputBoundary() {
            @Override
            public void prepareSuccessView(SelectDeleteProjectOutputData response) {
                assertEquals(user, response.getUser());
            }
        };

        SelectDeleteProjectInputBoundary interactor = new SelectDeleteProjectInteractor(successPresenter);
        interactor.execute(inputData);
    }
}

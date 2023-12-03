package use_case.check_remaining_time_test;

import junit.framework.TestCase;
import use_case.check_remaining_time.*;

import java.time.LocalDateTime;

public class CheckTimeInteractorTest extends TestCase {
    public void testExecute() {
        CheckTimeInputData correctInputData = new CheckTimeInputData(true,
                LocalDateTime.of(2023, 12, 5, 10, 0),
                LocalDateTime.of(2023, 12, 5, 20, 0));
        
        CheckTimeInputData noDueDateInputData = new CheckTimeInputData(false,
                LocalDateTime.of(2023, 12, 5, 10, 0),
                LocalDateTime.of(2023, 12, 5, 20, 0));
        
        CheckTimeInputData alreadyDueInputData = new CheckTimeInputData(false,
                LocalDateTime.of(2023, 12, 5, 10, 0),
                LocalDateTime.of(2023, 1, 1, 1, 1));
        
        CheckTimeOutputBoundary checkTimePresenter = new CheckTimeOutputBoundary() {
            @Override
            public void prepareSuccessView(CheckTimeOutputData dateTime) {
                assertEquals(dateTime.getOutputMessage(),
                        "You have 10 hours, and 0 minutes to complete this task!");
            }
            @Override
            public void prepareFailView(String error) {
                if (!error.equals("This does not have a due date.")){
                    assertEquals(error, "This was already due :(");
                }
                else if (!error.equals("This was already due :(")){
                    assertEquals(error, "This does not have a due date.");
                }
            }
        };
        
        CheckTimeInputBoundary interactor = new CheckTimeInteractor(checkTimePresenter);
        interactor.execute(correctInputData);
        interactor.execute(noDueDateInputData);
        interactor.execute(alreadyDueInputData);
    }
}


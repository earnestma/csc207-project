package interface_adapter.check_remaining_time;

import use_case.check_remaining_time.CheckTimeInputBoundary;
import use_case.check_remaining_time.CheckTimeInputData;

import java.time.LocalDateTime;

public class CheckTimeController {
    final CheckTimeInputBoundary checkTimeInteractor;
    
    public CheckTimeController(CheckTimeInputBoundary checkTimeInteractor) {
        this.checkTimeInteractor = checkTimeInteractor;
    }
    
    public void execute(boolean hasDueDateTime, LocalDateTime dueDateTime) {
        CheckTimeInputData checkTimeInputData = new CheckTimeInputData(hasDueDateTime, dueDateTime);
        
        checkTimeInteractor.execute(checkTimeInputData);
    }
}

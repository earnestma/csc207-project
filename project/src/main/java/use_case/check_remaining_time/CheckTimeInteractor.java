package use_case.check_remaining_time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CheckTimeInteractor implements CheckTimeInputBoundary{
    final CheckTimeOutputBoundary checkTimePresenter;

    public CheckTimeInteractor(CheckTimeOutputBoundary checkTimePresenter) {
        this.checkTimePresenter = checkTimePresenter;
    }

    public void execute(CheckTimeInputData checkTimeInputData) {
        boolean hasDateTime = checkTimeInputData.getHasDateTime();
        LocalDateTime dueDateTime = checkTimeInputData.getDueDateTime();
        LocalDateTime currentDateTime = findCurrentTime();
        
        if (!hasDateTime) {
            checkTimePresenter.prepareFailView("This task had no due date set.");
            // Does not have due date
        }
        else if (currentDateTime.compareTo(dueDateTime) > 0) {
            checkTimePresenter.prepareFailView("This was already due :(");
            // Show Fail Screen
            
        }
        
        else{
            int minutes = findMinutes(currentDateTime, dueDateTime);
            int days = minutes / 1440;
            int hours = (minutes - (days * 1440)) / 60;
            minutes = minutes - 60 * (24 * days + hours);

            String outputMessage = "You have ";
            if (days != 0) {
                outputMessage += days + " days, " + hours + " hours, and " + minutes;
            }
            else if (hours != 0) {
                outputMessage += hours + " hours, and " + minutes;
            }
            else{
                outputMessage += minutes;
            }
            outputMessage +=  " minutes to complete this task!";

            CheckTimeOutputData outputData = new CheckTimeOutputData(outputMessage);
            
            checkTimePresenter.prepareSuccessView(outputData);
        }

    }

    private LocalDateTime findCurrentTime() {
        return java.time.LocalDateTime.now();
    }

    private int findMinutes(LocalDateTime currentDateTime, LocalDateTime futureDateTime) {
        return (int) ChronoUnit.MINUTES.between(currentDateTime, futureDateTime);
    }
}

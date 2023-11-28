package use_case.check_remaining_time;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CheckTimeInteractor {
    final CheckTimeOutputBoundary CheckTimePresenter;

    public CheckTimeInteractor(CheckTimeOutputBoundary CheckTimePresenter){
        this.CheckTimePresenter = CheckTimePresenter;
    }

    public void execute(CheckTimeInputData checkTimeInputData){
        LocalDateTime dueDateTime = checkTimeInputData.getDueDateTime();
        LocalDateTime currentDateTime = findCurrentTime();
        if (currentDateTime.compareTo(dueDateTime) > 0){
            System.out.println("Already Due");
        }
        else{
            int minutes = findMinutes(currentDateTime, dueDateTime);

            int days = minutes / 1440;
            int hours = (minutes - (days * 1440)) / 60;
            minutes = minutes - 60 * (24 * days + hours);

            System.out.println("Days: " + days);
            System.out.println("Hours: " + hours);
            System.out.println("Minutes: " + minutes);

            CheckTimeOutputData outputData = new CheckTimeOutputData(currentDateTime, dueDateTime, false);
        }

    }

    private LocalDateTime findCurrentTime(){
        return java.time.LocalDateTime.now();
    }

    private int findMinutes(LocalDateTime currentDateTime, LocalDateTime futureDateTime){
        return (int) ChronoUnit.MINUTES.between(currentDateTime, futureDateTime);
    }

    private int findHours(LocalDateTime currentDateTime, LocalDateTime futureDateTime){
        return (int) ChronoUnit.HOURS.between(currentDateTime, futureDateTime);
    }

    private int findDays(LocalDateTime currentDateTime, LocalDateTime futureDateTime){
        return (int) ChronoUnit.DAYS.between(currentDateTime, futureDateTime);
    }
}

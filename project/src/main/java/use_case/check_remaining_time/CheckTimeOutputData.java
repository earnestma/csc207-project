package main.java.use_case.check_remaining_time;

import java.time.LocalDateTime;

public class CheckTimeOutputData {
    private final LocalDateTime currentDateTime;
    private final LocalDateTime dueDateTime;
    private boolean useCaseFailed;


    public CheckTimeOutputData(LocalDateTime currentDateTime,
                               LocalDateTime dueDateTime,
                               boolean useCaseFailed){
        this.currentDateTime = currentDateTime;
        this.dueDateTime = dueDateTime;
        this.useCaseFailed = useCaseFailed;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public LocalDateTime getDueDateTime() {
        return dueDateTime;
    private LocalDateTime dateTime;

    public CheckTimeOutputData(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

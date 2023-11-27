package main.java.use_case.check_remaining_time;

import java.time.LocalDateTime;

public class CheckTimeOutputData {
    private LocalDateTime dateTime;

    public CheckTimeOutputData(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}

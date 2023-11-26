package main.java.use_case.check_remaining_time;

import java.time.LocalDateTime;

public class CheckTimeInputData {
    final private LocalDateTime dueDateTime;

    public CheckTimeInputData(LocalDateTime dueDateTime){
        this.dueDateTime = dueDateTime;
    }

    public LocalDateTime getDueDateTime(){
        return dueDateTime;
    }
}

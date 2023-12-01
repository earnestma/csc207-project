package use_case.check_remaining_time;

import java.time.LocalDateTime;

public class CheckTimeInputData{
    final private LocalDateTime dueDateTime;
    final private boolean hasDateTime;
    
    public CheckTimeInputData(boolean hasDateTime, LocalDateTime dueDateTime){
        this.hasDateTime = hasDateTime;
        this.dueDateTime = dueDateTime;
    }

    public boolean getHasDateTime(){return hasDateTime;}
    public LocalDateTime getDueDateTime(){
        return dueDateTime;
    }
}

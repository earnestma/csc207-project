package use_case.check_remaining_time;

public class CheckTimeOutputData {
    private final String outputMessage;
    
    public CheckTimeOutputData(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {return outputMessage;}
}

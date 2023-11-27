package use_case.check_remaining_time;

public interface CheckTimeOutputBoundary {
    void prepareSuccessView(CheckTimeOutputData dateTime);

    void prepareFailView(String error);
}

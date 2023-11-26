package main.java.app;

import javax.swing.*;
import java.time.*;
import java.time.temporal.ChronoUnit;
import main.java.entity.Task;
import main.java.interface_adapter.check_remaining_time.CheckTimePresenter;
import main.java.use_case.check_remaining_time.CheckTimeInputData;
import main.java.use_case.check_remaining_time.CheckTimeInteractor;
import main.java.use_case.check_remaining_time.CheckTimeOutputBoundary;

public class Main {
    public static void main(String[] args) {
        /*
        JFrame application = new JFrame("Test");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LocalDateTime now = java.time.LocalDateTime.now();
        LocalDateTime future = java.time.LocalDateTime.of(2023, 12, 10, 4, 5);

        long minutes = ChronoUnit.MINUTES.between(now, future);
        long hours = ChronoUnit.HOURS.between(now, future);
        long days = ChronoUnit.DAYS.between(now, future);

        System.out.println(minutes);

        Task task = new Task("name", "desc", 0,
                java.time.LocalDateTime.of(2023, 12, 10, 4, 5), 1);  */

        CheckTimeInputData input_data =
                new CheckTimeInputData(java.time.LocalDateTime.of(2023, 12, 10, 4, 5));

        CheckTimeInteractor interactor = new CheckTimeInteractor(new CheckTimePresenter());
        interactor.execute(input_data);


    }
}

package app;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        /// JFrame application = new JFrame("Test");
        /// application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        LocalDateTime now = java.time.LocalDateTime.now();
        LocalDateTime future = java.time.LocalDateTime.of(2023, 12, 10, 4, 5);
        System.out.println(future.compareTo(future));

    }
}

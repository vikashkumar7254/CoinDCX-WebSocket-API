package com.example.Project.coindcx;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ErrorLogger{

    public static void logError(String error) {
        System.err.println("Error: " + error);
        // Optionally write errors to a log file
        try (FileWriter writer = new FileWriter("logs/app.log", true)) {
            writer.write(LocalDateTime.now() + " - ERROR: " + error + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logEvent(String event) {
        System.out.println("Event: " + event);
        // Optionally write events to a log file
        try (FileWriter writer = new FileWriter("logs/app.log", true)) {
            writer.write(LocalDateTime.now() + " - EVENT: " + event + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
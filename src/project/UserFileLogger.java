/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author LENOVO
 */
public class UserFileLogger {

    private static final String LOG_FILE_PATH = "user_logs.txt";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void log(String message) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(LOG_FILE_PATH, true))) {
            String timestamp = LocalDateTime.now().format(formatter);
            writer.write(timestamp + " - " + message);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logUserCreated(User user) {
        log("[User created] ID: " + user.getId() + " Role: " + user.getClass().getSimpleName() + " Name: " + user.getFirstName() + " " + user.getLastName()
                + " Email: " + user.getEmail());
    }

    public static void logUserUpdated(User user) {
        log("[User updated] ID: " + user.getId() + " Role: " + user.getClass().getSimpleName() + " Name: " + user.getFirstName() + " " + user.getLastName()
                + " Email: " + user.getEmail());
    }

    public static void logUserActivationChanged(User user, boolean newActiveStatus) {
        log("[User activation changed] ID: " + user.getId() + " Role: " + user.getClass().getSimpleName() + " Active: " + newActiveStatus);
    }

    public static void logUserLogin(User user) {
        log("[User logged in] ID: " + user.getId() + " Role: " + user.getClass().getSimpleName() + " Email: " + user.getEmail());
    }

    public static void logUserLogout(User user) {
        log("[User logged out] ID: " + user.getId() + " Role: " + user.getClass().getSimpleName() + " Email: " + user.getEmail());
    }
}

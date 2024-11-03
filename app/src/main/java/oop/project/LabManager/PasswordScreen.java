package oop.project.LabManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oop.project.users.Admin;

public class PasswordScreen {
    private Scene scene; private Admin admin = new Admin(true);
    private static final int MAX_ATTEMPTS = 3; // Maximum number of attempts
    private int attemptCount = 0; 

    public PasswordScreen(Stage primaryStage) {
        Label label = new Label("Enter Admin Password:");
        PasswordField passwordField = new PasswordField();
        Button submitButton = new Button("Submit");
        
        Label errorMessage = new Label();
        errorMessage.setStyle("-fx-text-fill: red;");

        submitButton.setOnAction(e -> {
            String inputPassword = passwordField.getText();
            if (admin.validatePassword(inputPassword)) {
                // If password is correct, proceed to Lab Selection Screen as Admin
                LabSelectionScreen labSelectionScreen = new LabSelectionScreen(primaryStage, true);
                primaryStage.setScene(labSelectionScreen.getScene());
            } else {
                // Increment the attempt count and check if max attempts reached
                attemptCount++;
                if (attemptCount >= MAX_ATTEMPTS) {
                    // Close the application if max attempts are reached
                    primaryStage.close();
                } else {
                    // Display error message and clear password field if attempt limit not yet reached
                    errorMessage.setText("Incorrect password. Application will close after " + MAX_ATTEMPTS + " attempts.");
                    passwordField.clear();
                }
            }
        });

        VBox layout = new VBox(10, label, passwordField, submitButton, errorMessage);
        layout.setAlignment(Pos.CENTER);
        this.scene = new Scene(layout, 500, 400);
    }

    public Scene getScene() {
        return scene;
    }

    // Verify the Admin password; replace "admin123" with your desired password
    /*private boolean verifyPassword(String inputPassword) {
        final String ADMIN_PASSWORD = "admin123";
        return ADMIN_PASSWORD.equals(inputPassword);
    }*/

}

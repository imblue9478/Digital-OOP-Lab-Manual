package oop.project.LabManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginScreen {
    private Scene scene;

    public LoginScreen(Stage primaryStage) {
        Label label1 = new Label("Welcome to your digital lab manual!");
        Label label2 = new Label("Please select your user type:");
        Button adminButton = new Button("Admin");
        Button studentButton = new Button("Student");

        adminButton.setOnAction(e -> {
            PasswordScreen passwordScreen = new PasswordScreen(primaryStage);
            primaryStage.setScene(passwordScreen.getScene());
        });

        studentButton.setOnAction(e -> {
            LabSelectionScreen labSelectionScreen = new LabSelectionScreen(primaryStage, false);
            primaryStage.setScene(labSelectionScreen.getScene());
        });

        VBox layout = new VBox(20, label1, label2, adminButton, studentButton);
        layout.setAlignment(Pos.CENTER);
        this.scene = new Scene(layout, 500, 400);
    }

    public Scene getScene() {
        return scene;
    }
}

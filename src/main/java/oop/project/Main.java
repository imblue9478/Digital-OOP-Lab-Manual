package oop.project;

import javafx.application.Application;
import javafx.stage.Stage;
import oop.project.LabManager.*;
//java --module-path C:\Users\aditi\openjfx-22.0.2_windows-x64_bin-sdk\javafx-sdk-22.0.2\lib --add-modules javafx.controls,javafx.fxml -jar app.jar
public class Main extends Application {
    @SuppressWarnings("exports")
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Digital Lab Manual");

        // Start with the Login Screen
        LoginScreen loginScreen = new LoginScreen(primaryStage);
        primaryStage.setScene(loginScreen.getScene());
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

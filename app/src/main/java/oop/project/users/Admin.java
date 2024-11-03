package oop.project.users;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Admin extends User {
    private final String password = "admin123"; // Admin password

    public Admin(boolean isAdmin) {
        super(true);
    }

    public boolean validatePassword(String inputPassword) {
        return password.equals(inputPassword);
    }

    public void showAddQuestionWindow(int LabNumber) {
        Stage addQuestionStage = new Stage();
        addQuestionStage.initModality(Modality.APPLICATION_MODAL);
        addQuestionStage.setTitle("Add New Question");

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20));

        TextField questionField = new TextField();
        questionField.setPromptText("Enter question text");

        TextField hintField = new TextField();
        hintField.setPromptText("Enter hint text");

        TextArea solutionField = new TextArea();
        solutionField.setPromptText("Enter solution code");
        solutionField.setWrapText(true);

        Button saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            String questionText = questionField.getText();
            String hintText = hintField.getText();
            String solutionText = solutionField.getText();
            int newQuestionNumber = saveNewQuestion(questionText, hintText, solutionText, LabNumber);
            addQuestionStage.close();
            if (newQuestionNumber != -1) {
                showSolutionInNewWindow(LabNumber, newQuestionNumber);
            }
        });

        layout.getChildren().addAll(new Label("Question:"), questionField, new Label("Hint:"), hintField, new Label("Solution:"), solutionField, saveButton);

        Scene scene = new Scene(layout, 400, 400);
        addQuestionStage.setScene(scene);
        addQuestionStage.show();
    }
    private int saveNewQuestion(String questionText, String hintText, String solutionText, int LabNumber) {
        List<Question> existingQuestions = loadQuestionsFromFile(LabNumber);
        int newQuestionNumber = existingQuestions.size() + 1;

        // Append question and hint to the lab file
        String labFilePath = "src/main/java/oop/project/labmanual/Lab" + LabNumber + ".txt";
        try (FileWriter writer = new FileWriter(labFilePath, true)) {
            writer.write("\nQuestion" + newQuestionNumber + ": " + questionText + "\n");
            writer.write("Hint" + newQuestionNumber + ": " + hintText + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        // Save solution to a new solution file
        String solutionFilePath = "src/main/java/oop/project/labmanual/Solutions/L" + LabNumber + "Q" + newQuestionNumber + ".txt";
        try (FileWriter writer = new FileWriter(solutionFilePath)) {
            writer.write(solutionText);
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }

        return newQuestionNumber;
    }
}

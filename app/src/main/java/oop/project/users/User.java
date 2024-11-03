package oop.project.users;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class User implements UserActions{
    @SuppressWarnings("unused")
    private boolean isAdmin;

    public User(boolean isAdmin) {
        this.isAdmin=isAdmin;
    }

    //public String getName() {
       // return name;
    //}
    public static class Question {
        public String text;
        public String hint;
        public int questionNumber;

        public Question(String text, String hint, int questionNumber) {
            this.text = text;
            this.hint = hint;
            this.questionNumber=questionNumber;
        }
    }
    public List<Question> loadQuestionsFromFile(int labNumber) {
        List<Question> questions = new ArrayList<>();
        String filepath = "src/main/java/oop/project/labmanual/Lab" + labNumber + ".txt";
        int questionCounter = 1; // Start question numbers from 1
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            String questionText = null;
            String hintText = null;
    
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Question")) {
                    questionText = line.substring(line.indexOf(":") + 1).trim();
                } else if (line.startsWith("Hint")) {
                    hintText = line.substring(line.indexOf(":") + 1).trim();
                }
    
                // Once both questionText and hintText are populated, create a Question instance
                if (questionText != null && hintText != null) {
                    questions.add(new Question(questionText, hintText, questionCounter));
                    questionCounter++; // Increment for the next question
                    questionText = null; // Reset for the next question
                    hintText = null;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return questions;
    }
    
    private String loadSolutionFromFile(int labNumber, int questionNumber) {
        StringBuilder solutionText = new StringBuilder();
        String filepath = "src/main/java/oop/project/labmanual/Solutions/L" + labNumber + "Q" + questionNumber + ".txt";
    
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                solutionText.append(line).append("\n");
            }
        } catch (IOException e) {
            solutionText.append("Solution file not found or could not be read.");
            e.printStackTrace();
        }
        return solutionText.toString();
    }
    
        public void showSolutionInNewWindow(int LabNumber, int questionNumber) {
            Stage solutionStage = new Stage();
            solutionStage.initModality(Modality.APPLICATION_MODAL);
            solutionStage.setTitle("Solution for Lab " + LabNumber + " - Question " + questionNumber);
        
            VBox solutionLayout = new VBox(10);
            solutionLayout.setPadding(new Insets(20));
        
            // Load solution content from file based on labNumber and questionNumber
            String solutionText = loadSolutionFromFile(LabNumber, questionNumber);
        
            TextArea solutionTextArea = new TextArea(solutionText);
            solutionTextArea.setWrapText(true);
            solutionTextArea.setEditable(false);
        
            solutionLayout.getChildren().add(solutionTextArea);
        
            Scene solutionScene = new Scene(solutionLayout, 500, 250);
            solutionStage.setScene(solutionScene);
            solutionStage.show();
        }
        
}
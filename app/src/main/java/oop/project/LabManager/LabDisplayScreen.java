package oop.project.LabManager;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import oop.project.users.Admin;
import oop.project.users.User;
import oop.project.users.User.Question;
import java.util.List;
public class LabDisplayScreen {
    Stage primaryStage; boolean isAdmin; Scene scene; int LabNumber; int questionCounter;
    User user = new User(isAdmin);
    /*private static class Question {
        String text;
        String hint;

        public Question(String text, String hint) {
            this.text = text;
            this.hint = hint;
        }
    }*/
    LabDisplayScreen(Stage primaryStage, boolean isAdmin, int LabNumber){
        this.primaryStage=primaryStage; this.isAdmin=isAdmin; this.LabNumber=LabNumber;
        
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        // Load questions and hints from file
        List<Question> questions = user.loadQuestionsFromFile(LabNumber);
        this.questionCounter = questions.size();
        // Display each question with a "Display Hint" button
        for (Question question : questions) {
            Label questionLabel = new Label("Q: " + question.text);
            questionLabel.setWrapText(true);
            questionLabel.setMaxWidth(600);
        
            Button hintButton = new Button("Display Hint");
            Label hintLabel = new Label("Hint: " + question.hint);
            hintLabel.setWrapText(true);
            hintLabel.setMaxWidth(600);
            hintLabel.setStyle("-fx-text-fill: red;");
            hintLabel.setVisible(false);
        
            hintButton.setOnAction(event -> hintLabel.setVisible(true));
        
            // Pass question.questionNumber to display the correct solution
            Button solutionButton = new Button("Display Solution");
            solutionButton.setOnAction(event -> user.showSolutionInNewWindow(LabNumber, question.questionNumber));
        
            root.getChildren().addAll(questionLabel, hintButton, hintLabel, solutionButton);
        }
        
        
        if (isAdmin) {
            Admin admin = new Admin(isAdmin);
            Button addQuestionButton = new Button("Add Question");
            addQuestionButton.setOnAction(event -> admin.showAddQuestionWindow(LabNumber));
            root.getChildren().add(addQuestionButton);
        }

        this.scene = new Scene(root, 900, 800);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Lab" + LabNumber);
        primaryStage.show();
    }
    /*public List<Question> loadQuestionsFromFile(int LabNumber) {
            List<Question> questions = new ArrayList<>();
            String filepath = "C:/Users/aditi/Downloads/app/src/main/java/oop/project/labmanual/Lab"+ LabNumber +".txt";
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line;
                String questionText = null;
                String hintText = null;
    
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Question")) {
                        // Extract question text after "QuestionX: "
                        questionText = line.substring(line.indexOf(":") + 1).trim();
                    } else if (line.startsWith("Hint")) {
                        // Extract hint text after "HintX: "
                        hintText = line.substring(line.indexOf(":") + 1).trim();
                    }
    
                    // If both question and hint are read, add to the list
                    if (questionText != null && hintText != null) {
                        questions.add(new Question(questionText, hintText));
                        questionText = null;
                        hintText = null;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return questions;
        }*/
    Scene getScene(){
        return scene;
    }
}

package oop.project.LabManager;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LabSelectionScreen{

    @SuppressWarnings("unused")
    private boolean isAdmin; @SuppressWarnings("unused")
    private Stage primaryStage;
    private Scene scene;
    LabSelectionScreen(Stage primaryStage, boolean isAdmin){
        this.primaryStage=primaryStage; this.isAdmin=isAdmin;
        Label header = new Label("Select lab:");
    Button L1Button = new Button("Lab 1: Java Data Types, Type Conversion and Operators");
    Button L2Button = new Button("Lab 2: Control Statements");
    Button L3Button = new Button("Lab 3: Arrays");
    Button L4Button = new Button("Lab 4: Classes and Methods");
    Button L5Button = new Button("Lab 5: Class Inheritance");
    Button L6Button = new Button("Lab 6: Classes-Access Control, Static Keyword, Nested & Inner Class, Final, Wrapper Class");
    L1Button.setOnAction(e->{
        LabDisplayScreen lab1display = new LabDisplayScreen(primaryStage, isAdmin, 1);
        primaryStage.setScene(lab1display.getScene());
    });
    L2Button.setOnAction(e->{
        LabDisplayScreen lab2display = new LabDisplayScreen(primaryStage, isAdmin, 2);
        primaryStage.setScene(lab2display.getScene());
    });
    L3Button.setOnAction(e->{
        LabDisplayScreen lab3display = new LabDisplayScreen(primaryStage, isAdmin, 3);
        primaryStage.setScene(lab3display.getScene());
    });
    L4Button.setOnAction(e->{
        LabDisplayScreen lab4display = new LabDisplayScreen(primaryStage, isAdmin, 4);
        primaryStage.setScene(lab4display.getScene());
    });
    L5Button.setOnAction(e->{
        LabDisplayScreen lab5display = new LabDisplayScreen(primaryStage, isAdmin, 5);
        primaryStage.setScene(lab5display.getScene());
    });
    L6Button.setOnAction(e->{
        LabDisplayScreen lab6display = new LabDisplayScreen(primaryStage, isAdmin, 6);
        primaryStage.setScene(lab6display.getScene());
    });
    VBox layout = new VBox(20, header, L1Button, L2Button, L3Button, L4Button, L5Button, L6Button);
        layout.setAlignment(Pos.CENTER);
        this.scene = new Scene(layout, 600, 500);
    }
    
    Scene getScene(){
        /*Pane pane = new Pane();
        
        // Create a Text object
        Text text = new Text("Hello, JavaFX!");
        
        // Set position of the text
        text.setX(50);  // X coordinate
        text.setY(100); // Y coordinate
        
        // Set font and color
        text.setFont(Font.font("Arial", 24)); // Set font and size
        text.setFill(Color.DARKBLUE);         // Set text color
        
        // Add Text to the Pane
        pane.getChildren().add(text);
        
        // Create a Scene and set it on the Stage
        Scene scene = new Scene(pane, 400, 200);
        /*Pane root = new Pane();
        Scene scene = new Scene(root, 800, 600);
        System.out.println("lolzies");*/
        return scene;

    }
}

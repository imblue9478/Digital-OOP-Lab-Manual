module oop.project {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens oop.project to javafx.fxml;
    exports oop.project;
}

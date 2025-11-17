package GradeBookApp;
/*
 * Course: CIS 505 Intermediate Java Programming
 * Name: Jarrett Nobles
 * Assignment: 10.2 GradeBookApp User Interface
 * File: NoblesGradeBookApp.java
 * Description: JavaFX user interface for the GradeBookApp capstone project.
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NoblesGradeBookApp extends Application {

    // Form fields
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;

    // Results area (for viewing saved entries later)
    private TextArea resultsArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("GradeBookApp");

        // ----- Form layout (labels + inputs) -----
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(20, 20, 10, 20));

        Label firstNameLabel = new Label("First Name:");
        firstNameField = new TextField();
        firstNameField.setPromptText("Enter first name");

        Label lastNameLabel = new Label("Last Name:");
        lastNameField = new TextField();
        lastNameField.setPromptText("Enter last name");

        Label courseLabel = new Label("Course:");
        courseField = new TextField();
        courseField.setPromptText("Enter course name");

        Label gradeLabel = new Label("Grade:");
        gradeComboBox = new ComboBox<>();
        gradeComboBox.getItems().addAll("A", "B", "C", "D", "F");
        gradeComboBox.setPromptText("Select grade");

        // Add nodes to grid: column, row
        formGrid.add(firstNameLabel, 0, 0);
        formGrid.add(firstNameField, 1, 0);

        formGrid.add(lastNameLabel, 0, 1);
        formGrid.add(lastNameField, 1, 1);

        formGrid.add(courseLabel, 0, 2);
        formGrid.add(courseField, 1, 2);

        formGrid.add(gradeLabel, 0, 3);
        formGrid.add(gradeComboBox, 1, 3);

        // ----- Buttons row (Save, Clear, View Grades) -----
        Button saveButton = new Button("Save Grade");
        Button clearButton = new Button("Clear Form");
        Button viewButton = new Button("View Grades");

        // NOTE: No event handling yet – that will be added in Sprint 2 (module 11).

        HBox buttonBar = new HBox(10);
        buttonBar.setAlignment(Pos.CENTER_LEFT);
        buttonBar.setPadding(new Insets(10, 20, 10, 20));
        buttonBar.getChildren().addAll(saveButton, clearButton, viewButton);

        // ----- Results / output area -----
        Label resultsLabel = new Label("Grade Entries:");
        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setWrapText(true);
        resultsArea.setPromptText("Saved grade entries will be displayed here in Sprint 2.");
        resultsArea.setPrefRowCount(10);

        VBox resultsBox = new VBox(5);
        resultsBox.setPadding(new Insets(0, 20, 20, 20));
        resultsBox.getChildren().addAll(resultsLabel, resultsArea);

        // ----- Main layout -----
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(formGrid, buttonBar, resultsBox);

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

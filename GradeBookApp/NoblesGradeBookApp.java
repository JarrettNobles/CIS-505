package GradeBookApp;
/*
 * Course: CIS 505 Intermediate Java Programming
 * Name: Jarrett Nobles
 * Assignment: 11.2 GradeBookApp – Event Handling
 * File: NoblesGradeBookApp.java
 * Description: JavaFX user interface and event handling for the GradeBookApp capstone project.
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

import java.io.*;

public class NoblesGradeBookApp extends Application {

    private static final String CSV_FILE_NAME = "grades.csv";

    // Form fields
    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private ComboBox<String> gradeComboBox;

    // Results area
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

        HBox buttonBar = new HBox(10);
        buttonBar.setAlignment(Pos.CENTER_LEFT);
        buttonBar.setPadding(new Insets(10, 20, 10, 20));
        buttonBar.getChildren().addAll(saveButton, clearButton, viewButton);

        // ----- Results / output area -----
        Label resultsLabel = new Label("Grade Entries:");
        resultsArea = new TextArea();
        resultsArea.setEditable(false);
        resultsArea.setWrapText(true);
        resultsArea.setPromptText("Saved grade entries will be displayed here.");
        resultsArea.setPrefRowCount(10);

        VBox resultsBox = new VBox(5);
        resultsBox.setPadding(new Insets(0, 20, 20, 20));
        resultsBox.getChildren().addAll(resultsLabel, resultsArea);

        // ----- Wire up event handlers -----
        saveButton.setOnAction(event -> handleSaveGrade());
        clearButton.setOnAction(event -> handleClearForm());
        viewButton.setOnAction(event -> handleViewGrades());

        // ----- Main layout -----
        VBox mainLayout = new VBox(10);
        mainLayout.getChildren().addAll(formGrid, buttonBar, resultsBox);

        Scene scene = new Scene(mainLayout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }//end start

    /**
     * Handles saving a grade entry to grades.csv and displaying it in the results area.
     */
    private void handleSaveGrade() {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String course = courseField.getText().trim();
        String grade = gradeComboBox.getValue();

        // Basic validation
        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || grade == null) {
            resultsArea.appendText("Please enter first name, last name, course, and select a grade.\n");
            return;
        }//end

        Student student = new Student(firstName, lastName, course, grade);

        File csvFile = new File(CSV_FILE_NAME);
        boolean fileExists = csvFile.exists();

        try (FileWriter fw = new FileWriter(csvFile, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {

            // Write header row if file is new
            if (!fileExists) {
                out.println("firstName,lastName,course,grade");
            }//end if

            // Write student record
            out.printf("%s,%s,%s,%s%n",
                    student.getFirstName(),
                    student.getLastName(),
                    student.getCourse(),
                    student.getGrade());

            resultsArea.appendText("Saved: " + student.toString() + System.lineSeparator());

            // Optionally clear the form after a successful save
            handleClearForm();

        } catch (IOException e) {
            resultsArea.appendText("Error saving grade: " + e.getMessage() + System.lineSeparator());
        }//end try-catch
    }//end handleSaveGrade

    /**
     * Clears the input form fields (but not the results area).
     */
    private void handleClearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        gradeComboBox.getSelectionModel().clearSelection();
    }//end handleClearForm

    /**
     * Reads grades.csv, converts lines to Student objects, and displays them using toString().
     */
    private void handleViewGrades() {
        File csvFile = new File(CSV_FILE_NAME);

        if (!csvFile.exists()) {
            resultsArea.appendText("No grades have been saved yet.\n");
            return;
        }//end if

        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line = reader.readLine(); // header row
            if (line == null) {
                resultsArea.appendText("grades.csv is empty.\n");
                return;
            }//end if

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    Student student = new Student(
                            parts[0],
                            parts[1],
                            parts[2],
                            parts[3]
                    );
                    builder.append(student.toString()).append(System.lineSeparator());
                }//end if
            }//end while

            if (builder.length() == 0) {
                resultsArea.appendText("No grade entries found in grades.csv.\n");
            } else {
                resultsArea.setText(builder.toString());
            }//end

        } catch (IOException e) {
            resultsArea.appendText("Error reading grades: " + e.getMessage() + System.lineSeparator());
        }//end try-catch
    }//end handleViewGrades

    public static void main(String[] args) {
        launch(args);
    }//end main
}//end

package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Enhanced Future Value (Assignment 8.2)
 * File: NoblesEnhancedFutureValueApp.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   JavaFX application that collects user inputs, calls
 *   FinanceCalculator.calculateFutureValue, and displays
 *   "Calculation as of <today’s date>" and
 *   "The future value is <futureValue>" in the UI.
 *
 *   Required private methods:
 *     - clearFormFields() : void
 *     - calculateResults(): void
 *     - getTodaysDate()   : String (format "MM/dd/yyyy")
 *
 *   Button wiring (required):
 *     - btnClear.setOnAction(e -> clearFormFields());
 *     - btnCalculate.setOnAction(e -> calculateResults());
 * ------------------------------------------------------------
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoblesEnhancedFutureValueApp extends Application {

    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private ComboBox<Integer> cbYears;
    private Label lblFutureValueDate;
    private TextArea txtResults;
    private Button btnCalculate;
    private Button btnClear;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Enhanced Future Value");

        Label lblHeader = new Label("Enhanced Future Value Calculator");
        lblHeader.setFont(Font.font(18));

        Label lblMonthlyPayment = new Label("Monthly Payment:");
        Label lblInterestRate  = new Label("Interest Rate (%):");
        Label lblYears         = new Label("Years:");
        lblFutureValueDate     = new Label("");

        txtMonthlyPayment = new TextField();
        txtMonthlyPayment.setPromptText("e.g., 250.00");

        txtInterestRate = new TextField();
        txtInterestRate.setPromptText("e.g., 5.0");

        cbYears = new ComboBox<>();
        cbYears.getItems().add(0); // required so clear sets it to 0
        for (int y = 1; y <= 50; y++) cbYears.getItems().add(y);
        cbYears.setValue(0);

        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setPrefRowCount(4);
        txtResults.setWrapText(true);

        btnCalculate = new Button("Calculate");
        btnClear     = new Button("Clear");

        GridPane root = new GridPane();
        root.setPadding(new Insets(16));
        root.setHgap(10);
        root.setVgap(10);

        root.add(lblHeader, 0, 0, 2, 1);
        root.add(lblMonthlyPayment, 0, 1);
        root.add(txtMonthlyPayment, 1, 1);
        root.add(lblInterestRate, 0, 2);
        root.add(txtInterestRate, 1, 2);
        root.add(lblYears, 0, 3);
        root.add(cbYears, 1, 3);

        GridPane buttons = new GridPane();
        buttons.setHgap(10);
        buttons.add(btnCalculate, 0, 0);
        buttons.add(btnClear, 1, 0);
        buttons.setAlignment(Pos.CENTER_LEFT);
        root.add(buttons, 1, 4);

        root.add(lblFutureValueDate, 0, 5, 2, 1);
        root.add(txtResults, 0, 6, 2, 1);

        // Required event wiring
        btnClear.setOnAction(e -> clearFormFields());
        btnCalculate.setOnAction(e -> calculateResults());

        Scene scene = new Scene(root, 520, 360);
        stage.setScene(scene);
        stage.show();
    }//end start

    // Required: clear all fields and set cbYears to 0
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        txtResults.setText("");
        lblFutureValueDate.setText("");
        cbYears.setValue(0);
    }//end clearFormFields

    // Required: perform calculation and set required UI strings
    private void calculateResults() {
        try {
            double monthlyPayment = Double.parseDouble(txtMonthlyPayment.getText().trim());
            double rate = Double.parseDouble(txtInterestRate.getText().trim());
            Integer years = cbYears.getValue();

            if (years == null || years < 1) {
                showInfo("Validation Error", "Please select Years greater than 0.");
                return;
            }//end if
            if (monthlyPayment < 0 || rate < 0) {
                showInfo("Validation Error", "Monthly Payment and Interest Rate must be non-negative.");
                return;
            }//end if

            double futureValue = FinanceCalculator.calculateFutureValue(monthlyPayment, rate, years);
            lblFutureValueDate.setText("Calculation as of " + getTodaysDate());

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            txtResults.setText("The future value is " + currency.format(futureValue));

        } catch (NumberFormatException nfe) {
            showInfo("Input Error", "Please enter valid numeric values for Monthly Payment and Interest Rate.");
        } catch (Exception ex) {
            showInfo("Error", "An unexpected error occurred: " + ex.getMessage());
        }//end try-catch
    }//end calculateResults

    // Required: "MM/dd/yyyy" format
    private String getTodaysDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    }//end getTodaysDate

    private void showInfo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }//end showInfo

    public static void main(String[] args) {
        launch(args);
    }//end main
}//end class

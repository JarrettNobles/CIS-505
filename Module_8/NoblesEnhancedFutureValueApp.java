package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Future Value App (Week 2)
 * File: NoblesEnhancedFutureValueApp.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   JavaFX UI that matches the assignment's example exactly.
 *   - Red hint: "Enter 11.1% as 11.1"
 *   - Date label above the results: "Calculation as of <MM/dd/yyyy>"
 *   - TextArea shows only: "The future value is <currency>"
 *   - Clear sets Years to 0 and clears all fields.
 *
 *   Required private methods:
 *     clearFormFields(), calculateResults(), getTodaysDate()
 * ------------------------------------------------------------
 */

import javafx.application.Application;
import javafx.geometry.HPos;
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
    private Label lblCalcDate;   // "Calculation as of <date>"
    private TextArea txtResults; // "The future value is $X,XXX.XX"

    @Override
    public void start(Stage stage) {
        stage.setTitle("Future Value App");

        // Header (visual only)
        Label header = new Label("Future Value App");
        header.setFont(Font.font(18));

        // Labels
        Label lblMonthly = new Label("Monthly Payment:");
        Label lblRate    = new Label("Interest Rate:");
        Label lblYears   = new Label("Years:");
        Label lblHint    = new Label("Enter 11.1% as 11.1");
        lblHint.setStyle("-fx-text-fill: red;");

        // Inputs
        txtMonthlyPayment = new TextField();
        txtInterestRate   = new TextField();

        cbYears = new ComboBox<>();
        cbYears.getItems().add(0); // required so Clear can set it to 0
        for (int y = 1; y <= 50; y++) cbYears.getItems().add(y);
        cbYears.setValue(0);

        // Date label (above results)
        lblCalcDate = new Label("");

        // Results box (read-only)
        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setWrapText(true);
        txtResults.setPrefRowCount(4);

        // Buttons
        Button btnClear = new Button("Clear");
        Button btnCalc  = new Button("Calculate");

        // Layout
        GridPane g = new GridPane();
        g.setPadding(new Insets(14));
        g.setVgap(10);
        g.setHgap(12);
        g.setAlignment(Pos.TOP_LEFT);

        // Row 0
        g.add(header, 0, 0, 3, 1);

        // Row 1
        g.add(lblMonthly,        0, 1);
        g.add(txtMonthlyPayment, 1, 1, 2, 1);

        // Row 2 (rate + red hint)
        g.add(lblRate,        0, 2);
        g.add(txtInterestRate,1, 2);
        g.add(lblHint,        2, 2);

        // Row 3 (years)
        g.add(lblYears, 0, 3);
        g.add(cbYears,  1, 3);

        // Row 4 (buttons)
        g.add(btnClear, 0, 4);
        g.add(btnCalc,  1, 4);
        GridPane.setHalignment(btnCalc, HPos.LEFT);

        // Row 5 (calculation date)
        g.add(lblCalcDate, 0, 5, 3, 1);

        // Row 6 (results area)
        g.add(txtResults, 0, 6, 3, 1);

        // Wire events
        btnClear.setOnAction(e -> clearFormFields());
        btnCalc.setOnAction(e -> calculateResults());

        stage.setScene(new Scene(g, 440, 360));
        stage.show();
    }

    // Clears all fields and resets years to 0.
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        cbYears.setValue(0);
        lblCalcDate.setText("");
        txtResults.setText("");
    }

    // Reads inputs, computes, writes exact strings to the exact places.
    private void calculateResults() {
        try {
            double monthly = Double.parseDouble(txtMonthlyPayment.getText().trim());
            double rate    = Double.parseDouble(txtInterestRate.getText().trim());
            Integer years  = cbYears.getValue();

            if (years == null || years < 1) {
                showInfo("Validation", "Please select Years greater than 0.");
                return;
            }
            if (monthly < 0 || rate < 0) {
                showInfo("Validation", "Values must be non-negative.");
                return;
            }

            double fv = FinanceCalculator.calculateFutureValue(monthly, rate, years);

            // EXACT placement/wording
            lblCalcDate.setText("Calculation as of " + getTodaysDate());

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            txtResults.setText("The future value is " + currency.format(fv));

        } catch (NumberFormatException ex) {
            showInfo("Input Error", "Enter numeric values (e.g., 200 and 3.5).");
        }
    }

    // MM/dd/yyyy
    private String getTodaysDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    }

    private void showInfo(String title, String msg) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle(title);
        a.setHeaderText(null);
        a.setContentText(msg);
        a.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

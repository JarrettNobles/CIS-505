package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Enhanced Future Value App
 * File: NoblesFutureValueApp.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   JavaFX UI for the Future Value App. Collects Monthly Payment,
 *   Interest Rate (% as 11.1), and Years (ComboBox). On Calculate,
 *   shows "Calculation as of <MM/dd/yyyy>" above the results box
 *   and writes "The future value is <currency>" into the box.
 *
 *   Required private methods:
 *     - clearFormFields() : void
 *     - calculateResults(): void
 *     - getTodaysDate()   : String (MM/dd/yyyy)
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
    private Label lblCalcDate;       // "Calculation as of <date>"
    private TextArea txtResults;     // "The future value is $X,XXX.XX"

    @Override
    public void start(Stage stage) {
        stage.setTitle("Future Value App");

        // Header (optional visual, not required by logic)
        Label header = new Label("Future Value App");
        header.setFont(Font.font(18));

        // Field labels
        Label lblMonthly = new Label("Monthly Payment:");
        Label lblRate    = new Label("Interest Rate:");
        Label lblYears   = new Label("Years:");
        Label lblHint    = new Label("Enter 11.1% as 11.1");
        lblHint.setStyle("-fx-text-fill: red;");

        // Inputs
        txtMonthlyPayment = new TextField();
        txtInterestRate   = new TextField();

        cbYears = new ComboBox<>();
        cbYears.getItems().add(0);                 // so Clear can set to 0
        for (int y = 1; y <= 50; y++) cbYears.getItems().add(y);
        cbYears.setValue(0);

        // Date label ABOVE the results box (empty until Calculate)
        lblCalcDate = new Label("");

        // Results box
        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setPrefRowCount(4);
        txtResults.setWrapText(true);

        // Buttons
        Button btnClear = new Button("Clear");
        Button btnCalc  = new Button("Calculate");

        // Layout grid
        GridPane g = new GridPane();
        g.setPadding(new Insets(14));
        g.setVgap(10);
        g.setHgap(12);

        // Row 0: header
        g.add(header, 0, 0, 3, 1);

        // Row 1: Monthly Payment
        g.add(lblMonthly,        0, 1);
        g.add(txtMonthlyPayment, 1, 1, 2, 1);

        // Row 2: Interest Rate + red hint on same row (to the right)
        g.add(lblRate,       0, 2);
        g.add(txtInterestRate, 1, 2);
        g.add(lblHint,       2, 2);

        // Row 3: Years
        g.add(lblYears, 0, 3);
        g.add(cbYears,  1, 3);

        // Row 4: Buttons
        g.add(btnClear, 0, 4);
        g.add(btnCalc,  1, 4);
        GridPane.setHalignment(btnCalc, HPos.LEFT);

        // Row 5: Calculation as of <date>
        g.add(lblCalcDate, 0, 5, 3, 1);

        // Row 6: Results area (label on the left in example is just spacing; the
        // text content itself starts with "The future value is ...")
        g.add(txtResults, 0, 6, 3, 1);

        // Alignments
        g.setAlignment(Pos.TOP_LEFT);

        // Wire events (exact behavior)
        btnClear.setOnAction(e -> clearFormFields());
        btnCalc.setOnAction(e -> calculateResults());

        stage.setScene(new Scene(g, 420, 360));
        stage.show();
    }

    // Clears all fields and sets Years to 0; wipes date/box text.
    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        cbYears.setValue(0);
        lblCalcDate.setText("");
        txtResults.setText("");
    }

    // Reads inputs, computes future value via FinanceCalculator, and prints
    // the required strings in the required places.
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

            // EXACT strings/placement
            lblCalcDate.setText("Calculation as of " + getTodaysDate());

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            txtResults.setText("The future value is " + currency.format(fv));

        } catch (NumberFormatException ex) {
            showInfo("Input Error", "Enter numeric values (e.g., 200 and 3.5).");
        }
    }

    // MM/dd/yyyy format
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

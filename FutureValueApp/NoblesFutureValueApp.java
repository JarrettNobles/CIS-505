package FutureValueApp;

/*
 * ------------------------------------------------------------
 * File: NoblesFutureValueApp.java
 * Course: CIS-505 (Bellevue University)
 * Assignment: 7.2 – Future Value App (JavaFX)
 * Author: Jarrett Nobles
 * Date: 10/26/2025
 * Description:
 *   JavaFX application that calculates the future value of an
 *   investment based on an initial amount, a yearly interest
 *   rate, and a selected number of years. The UI is built to
 *   match the exhibits in the assignment PDF, including:
 *     - GridPane alignment, padding, hgap, vgap
 *     - Label/Button texts
 *     - Red right-aligned interest-rate format label
 *     - HBox container for action buttons with specific spacing
 *       and padding
 *   All code comments follow our established comment style.
 *
 * References:
 *   JavaFX SDK: https://gluonhq.com/products/javafx/
 * ------------------------------------------------------------
 */

import javafx.application.Application;
import javafx.geometry.HPos;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.text.NumberFormat;

/**
 * NoblesFutureValueApp
 *  - Extends JavaFX Application and builds the UI described in Exhibits A–F.
 *  - Provides Calculate and Clear actions.
 */
public class NoblesFutureValueApp extends Application {

    // ------------------------------------------------------------
    // Private UI Variables (per requirement #5)
    // ------------------------------------------------------------
    private TextField txtInvestmentAmount;   // investment amount input
    private TextField txtYearlyInterestRate; // yearly interest rate input (e.g., 11.1 for 11.1%)
    private TextArea  txtAreaResults;        // results display area

    private Label lblInvestmentAmount;       // "Investment Amount:"
    private Label lblYearlyInterestRate;     // "Yearly Interest Rate:"
    private Label lblYears;                  // "Years:"
    private Label lblFutureValue;            // "Future Value:"
    private Label lblInterestRateFormat;     // red, right-aligned hint label

    private ComboBox<Integer> cboYears;      // years selection
    private Button btnClear;                 // "Clear"
    private Button btnCalculate;             // "Calculate"

    // ------------------------------------------------------------
    // JavaFX Entry Point
    // ------------------------------------------------------------
    @Override
    public void start(Stage primaryStage) {
        // 1) Create GridPane and apply layout (Requirement c)
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);

        // 2) Initialize Labels with texts to match exhibits (Requirements a + Exhibits A–D)
        lblInvestmentAmount   = new Label("Investment Amount:");
        lblYearlyInterestRate = new Label("Yearly Interest Rate:");
        lblYears              = new Label("Years:");
        lblFutureValue        = new Label("Future Value:");
        lblInterestRateFormat = new Label("Enter interest rate as 11.1"); // Exhibit E hint text
        lblInterestRateFormat.setTextFill(Color.RED);

        // Right-align the hint label within its grid cell (Requirement d)
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        // 3) Initialize TextFields / TextArea
        txtInvestmentAmount   = new TextField();
        txtYearlyInterestRate = new TextField();

        txtAreaResults = new TextArea();
        txtAreaResults.setEditable(false);
        txtAreaResults.setWrapText(true);
        txtAreaResults.setPrefRowCount(6);

        // 4) Initialize ComboBox<Integer> for years
        cboYears = new ComboBox<>();
        for (int i = 1; i <= 30; i++) {
            cboYears.getItems().add(i);
        }
        cboYears.getSelectionModel().selectFirst(); // default to 1 year

        // 5) Initialize Buttons with texts to match exhibits (Requirement b)
        btnClear     = new Button("Clear");
        btnCalculate = new Button("Calculate");

        // 6) Add controls to the GridPane in logical positions (Requirement d)
        // Row 0: Investment Amount
        grid.add(lblInvestmentAmount,   0, 0);
        grid.add(txtInvestmentAmount,   1, 0);

        // Row 1: Yearly Interest Rate + format hint (right aligned, red)
        grid.add(lblYearlyInterestRate, 0, 1);
        grid.add(txtYearlyInterestRate, 1, 1);
        grid.add(lblInterestRateFormat, 1, 2); // place hint below the interest field

        // Row 2: Years (label + combo)
        grid.add(lblYears, 0, 3);
        grid.add(cboYears, 1, 3);

        // Row 3: Future Value (label + results area)
        grid.add(lblFutureValue, 0, 4);
        grid.add(txtAreaResults, 1, 4);

        // 7) HBox for action buttons (Requirement e)
        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);

        // Place the button container on a new row spanning two columns
        grid.add(actionBtnContainer, 0, 5, 2, 1);

        // 8) Wire up Button actions
        btnCalculate.setOnAction(e -> onCalculate());
        btnClear.setOnAction(e -> onClear());

        // 9) Stage title (Requirement f)
        primaryStage.setTitle("Nobles Future Value App");

        // 10) Show scene
        Scene scene = new Scene(grid);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ------------------------------------------------------------
    // Event Handlers
    // ------------------------------------------------------------

    /**
     * onCalculate
     *  - Validates inputs and computes the future value.
     *  - Displays formatted output in the results TextArea.
     */
    private void onCalculate() {
        try {
            double principal = parseCurrencyLike(txtInvestmentAmount.getText());
            double ratePct   = Double.parseDouble(txtYearlyInterestRate.getText().trim());
            int years        = (cboYears.getValue() == null) ? 1 : cboYears.getValue();

            // Convert percent to decimal (user enters e.g., 11.1 meaning 11.1%)
            double rate = ratePct / 100.0;
            double futureValue = principal * Math.pow(1.0 + rate, years);

            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent  = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // Two leading spaces per our usual output style
            StringBuilder sb = new StringBuilder();
            sb.append("  Investment Amount: ").append(currency.format(principal)).append("\n");
            sb.append("  Yearly Interest Rate: ").append(ratePct).append("%").append("\n");
            sb.append("  Years: ").append(years).append("\n");
            sb.append("  Future Value: ").append(currency.format(futureValue)).append("\n");

            txtAreaResults.setText(sb.toString());
        } catch (NumberFormatException ex) {
            // Display a simple validation message in the results area
            txtAreaResults.setText(
                    "  Please enter a valid number for Investment Amount and Yearly Interest Rate.\n" +
                            "  Hint: Interest rate should look like 11.1 (for 11.1%)."
            );
        }
    }

    /**
     * onClear
     *  - Resets all inputs and clears the results area.
     */
    private void onClear() {
        txtInvestmentAmount.clear();
        txtYearlyInterestRate.clear();
        cboYears.getSelectionModel().selectFirst();
        txtAreaResults.clear();
    }

    // ------------------------------------------------------------
    // Helpers
    // ------------------------------------------------------------

    /**
     * parseCurrencyLike
     *  - Allows users to type either plain numbers or currency-like strings.
     *  - Removes common currency formatting before parsing.
     *
     * @param input raw input string
     * @return parsed double value
     */
    private double parseCurrencyLike(String input) {
        if (input == null) {
            throw new NumberFormatException("Null input");
        }
        String cleaned = input.trim()
                .replace("$", "")
                .replace(",", "");
        return Double.parseDouble(cleaned);
    }

    // ------------------------------------------------------------
    // Main
    // ------------------------------------------------------------
    public static void main(String[] args) {
        launch(args);
    }
}


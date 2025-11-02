package Module_8;
/*
 * ------------------------------------------------------------
 * Program: Future Value App (Week 8)
 * File: NoblesEnhancedFutureValueApp.java
 * Author: Jarrett Nobles
 * Course: CIS-505 — Software Engineering
 * Date: 2025-11-02
 * Description:
 *   JavaFX UI that matches the assignment figure exactly.
 *   - Red hint: "Enter 11.1% as 11.1"
 *   - Date label above results: "Calculation as of <MM/dd/yyyy>"
 *   - TextArea shows only: "The future value is <currency>"
 *   - Clear and Calculate buttons side-by-side, aligned left.
 * ------------------------------------------------------------
 */

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NoblesEnhancedFutureValueApp extends Application {

    private TextField txtMonthlyPayment;
    private TextField txtInterestRate;
    private ComboBox<Integer> cbYears;
    private Label lblCalcDate;
    private TextArea txtResults;

    @Override
    public void start(Stage stage) {
        stage.setTitle("Future Value App");

        Label header = new Label("Future Value App");
        header.setFont(Font.font(18));

        Label lblMonthly = new Label("Monthly Payment:");
        Label lblRate    = new Label("Interest Rate:");
        Label lblYears   = new Label("Years:");
        Label lblHint    = new Label("Enter 11.1% as 11.1");
        lblHint.setStyle("-fx-text-fill: red;");

        txtMonthlyPayment = new TextField();
        txtInterestRate   = new TextField();

        cbYears = new ComboBox<>();
        cbYears.getItems().add(0);
        for (int y = 1; y <= 50; y++) cbYears.getItems().add(y);
        cbYears.setValue(0);

        lblCalcDate = new Label("");

        txtResults = new TextArea();
        txtResults.setEditable(false);
        txtResults.setWrapText(true);
        txtResults.setPrefRowCount(3);

        Button btnClear = new Button("Clear");
        Button btnCalc  = new Button("Calculate");

        // Properly align the buttons horizontally near each other
        HBox buttonBox = new HBox(10, btnClear, btnCalc);
        buttonBox.setAlignment(Pos.CENTER_LEFT);

        GridPane g = new GridPane();
        g.setPadding(new Insets(14));
        g.setVgap(10);
        g.setHgap(12);
        g.setAlignment(Pos.TOP_LEFT);

        g.add(header, 0, 0, 3, 1);
        g.add(lblMonthly, 0, 1);
        g.add(txtMonthlyPayment, 1, 1, 2, 1);
        g.add(lblRate, 0, 2);
        g.add(txtInterestRate, 1, 2);
        g.add(lblHint, 2, 2);
        g.add(lblYears, 0, 3);
        g.add(cbYears, 1, 3);
        g.add(buttonBox, 1, 4);  // align both buttons together
        g.add(lblCalcDate, 0, 5, 3, 1);
        g.add(txtResults, 0, 6, 3, 1);

        btnClear.setOnAction(e -> clearFormFields());
        btnCalc.setOnAction(e -> calculateResults());

        stage.setScene(new Scene(g, 440, 360));
        stage.show();
    }

    private void clearFormFields() {
        txtMonthlyPayment.setText("");
        txtInterestRate.setText("");
        cbYears.setValue(0);
        lblCalcDate.setText("");
        txtResults.setText("");
    }

    private void calculateResults() {
        try {
            double monthly = Double.parseDouble(txtMonthlyPayment.getText().trim());
            double rate    = Double.parseDouble(txtInterestRate.getText().trim());
            Integer years  = cbYears.getValue();

            if (years == null || years < 1) {
                show("Validation", "Please select Years greater than 0.");
                return;
            }
            if (monthly < 0 || rate < 0) {
                show("Validation", "Values must be non-negative.");
                return;
            }

            double fv = FinanceCalculator.calculateFutureValue(monthly, rate, years);
            lblCalcDate.setText("Calculation as of " + getTodaysDate());
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            txtResults.setText("The future value is " + currency.format(fv));

        } catch (NumberFormatException ex) {
            show("Input Error", "Enter numeric values (e.g., 200 and 3.5).");
        }
    }

    private String getTodaysDate() {
        return new SimpleDateFormat("MM/dd/yyyy").format(new Date());
    }

    private void show(String title, String msg) {
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

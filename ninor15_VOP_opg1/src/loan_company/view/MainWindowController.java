package loan_company.view;/**
 * Created 2/3/16
 *
 * @author Niels Norberg
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import loan_company.control.LoanDriver;
import loan_company.control.MainDriver;
import loan_company.model.LoanInterface;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private RadioButton personalToggleButton;

    @FXML
    private ToggleGroup typeToggleGroup;

    @FXML
    private RadioButton businessToggleButton;

    @FXML
    private RadioButton shortToggleButton;

    @FXML
    private ToggleGroup durationToggleGroup;

    @FXML
    private RadioButton mediumToggleButton;

    @FXML
    private RadioButton longToggleButton;
    @FXML
    private TextArea openLoanTextArea;

    private LoanDriver loanDriver;
    private Stage primaryStage;

    @FXML
    void initialize() {
        loanDriver = MainDriver.getINSTANCE().getDriver();
        primaryStage = MainDriver.getINSTANCE().getPrimaryStage();

        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            verifyAmountField(oldValue, newValue);
        });

        nameTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            verifyNameNotEmpty(newValue);
        });
    }

    private void verifyNameNotEmpty(String newValue) {
        if (newValue.trim().equals("")) {
            markFieldAsError(nameTextField);
        } else {
            unmarkFieldAsError(nameTextField);
        }
    }

    private void markFieldAsError(TextField fieldToMark) {
        if(!fieldToMark.getStyleClass().contains("error")) {
            fieldToMark.getStyleClass().add("error");
        }
    }

    private void unmarkFieldAsError(TextField fieldToUnmark) {
        if(fieldToUnmark.getStyleClass().contains("error")) {
            fieldToUnmark.getStyleClass().remove("error");
        }
    }

    private void verifyAmountField(String oldValue, String newValue) {
        if (!newValue.equals("")) {
            try {
                if (Integer.parseInt(newValue) > 500000 || Integer.parseInt(newValue) <= 0) {
                    //amountTextField.setText(oldValue);
                    markFieldAsError(amountTextField);
                    return;
                }
                unmarkFieldAsError(amountTextField);
            } catch (NumberFormatException e) {
                //amountTextField.setText(oldValue);
                markFieldAsError(amountTextField);
            } catch (Exception e) {
                Logger.getGlobal().log(Level.INFO, "An exception occured when parsing the amount.\n" + e.getMessage());
                markFieldAsError(amountTextField);
            }
        }
    }

    @FXML
    void openFileClicked(ActionEvent event) {
        FileChooser openFileDialog = new FileChooser();
        openFileDialog.setInitialFileName("loanFile");
        openFileDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File file = openFileDialog.showOpenDialog(primaryStage);

        if (file == null) {
            Logger.getGlobal().log(Level.INFO, "No file selected");
            return;
        }

        openLoanTextArea.setText(loanDriver.readFromFile(file));
    }

    @FXML
    void saveToFileClicked(ActionEvent event) {
        FileChooser saveFileDialog = new FileChooser();
        saveFileDialog.setInitialFileName(nameTextField.getText());
        saveFileDialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text files", "*.txt"));
        File file = saveFileDialog.showSaveDialog(primaryStage);

        if (file == null) {
            Logger.getGlobal().log(Level.INFO, "No file selected");
            return;
        }

        if (!file.getName().endsWith(".txt")) {
            file = new File(file.getAbsolutePath() + ".txt");
        }

        loanDriver.writeToFile(file);
    }

    @FXML
    void createLoanClicked(ActionEvent event) {
        if (isDataValid()) {
            LoanInterface.LoanDuration duration = LoanInterface.LoanDuration.SHORT_TERM;

            if (mediumToggleButton.isSelected()) {
                duration = LoanInterface.LoanDuration.MIDDLE_TERM;
            } else if (longToggleButton.isSelected()) {
                duration = LoanInterface.LoanDuration.LONG_TERM;
            }

            if (businessToggleButton.isSelected()) {
                loanDriver.addBusinessLoan(MainDriver.loanID++, nameTextField.getText(), Integer.parseInt(amountTextField.getText()), duration);
            } else {
                loanDriver.addPersonalLoan(MainDriver.loanID++, nameTextField.getText(), Integer.parseInt(amountTextField.getText()), duration);
            }


        }
    }

    private boolean isDataValid() {
        boolean result = true;
        if (typeToggleGroup.getSelectedToggle() == null) {
            result = false;
        }

        try {
            Integer.parseInt(amountTextField.getText());
        } catch (NumberFormatException e) {
            Logger.getGlobal().log(Level.INFO, "A non-number was entered for amount");
            result = false;
            markFieldAsError(amountTextField);
        } catch (Exception e) {
            Logger.getGlobal().log(Level.INFO, "An invalid number was entered (too large)");
            result = false;
            markFieldAsError(amountTextField);
        }

        if (durationToggleGroup.getSelectedToggle() == null) {
            result = false;
        }

        if (nameTextField.getText().trim().equals("")) {
            markFieldAsError(nameTextField);
            result = false;
        }

        return result;
    }
}

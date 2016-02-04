package loan_company.view;/**
 * Created 2/3/16
 *
 * @author Niels Norberg
 */

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import loan_company.control.LoanDriver;
import loan_company.control.MainDriver;
import org.omg.CORBA.MARSHAL;

import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController {

    @FXML
    private TextField nameTextField;
    @FXML
    private TextField amountTextField;
    @FXML
    private ToggleGroup typeToggleGroup;
    @FXML
    private ToggleGroup durationToggleGroup;
    @FXML
    private TextArea openLoanTextArea;

    private LoanDriver driver;
    private Stage primaryStage;

    @FXML
    void initialize() {
        driver = MainDriver.getINSTANCE().getDriver();
        primaryStage = MainDriver.getINSTANCE().getPrimaryStage();

        amountTextField.textProperty().addListener((observable, oldValue, newValue) -> {
            try {
                Integer.parseInt(newValue);
            } catch (NumberFormatException e) {
                amountTextField.setText(oldValue);
                amountTextField.getBorder().getStrokes().get(0).
            }
        });
    }

    @FXML
    void openFileClicked(ActionEvent event) {
        FileChooser openFileDialog = new FileChooser();
        File file = openFileDialog.showOpenDialog(primaryStage);

        if (file == null) {
            Logger.getGlobal().log(Level.INFO, "No file selected");
            return;
        }

        openLoanTextArea.setText(driver.readFromFile(file));
    }

    @FXML
    void saveToFileClicked(ActionEvent event) {
        FileChooser saveFileDialog = new FileChooser();
        File file = saveFileDialog.showSaveDialog(primaryStage);

        if (file == null) {
            Logger.getGlobal().log(Level.INFO, "No file selected");
        }

        driver.writeToFile(file);
    }

    @FXML
    void createLoanClicked(ActionEvent event) {
        if (isDataValid()) {

        } else {
            Dialog alertDialog = new Dialog();
            alertDialog.setTitle("Invalid data");
            alertDialog.setHeaderText("");
            alertDialog.setContentText("Please enter only valid data");
        }
    }

    private boolean isDataValid() {
        if(typeToggleGroup.getSelectedToggle() == null) {
            return false;
        }

        try {
            Integer.parseInt(amountTextField.getText());
        } catch (NumberFormatException e) {
            Logger.getGlobal().log(Level.INFO, "A non-number was entered for amount");
            return false;
        }

        if(durationToggleGroup.getSelectedToggle() == null) {
            return false;
        }

        return true;
    }
}

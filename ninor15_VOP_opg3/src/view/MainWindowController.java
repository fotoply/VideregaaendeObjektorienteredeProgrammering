package view;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import poly_and_strings.FlipUpperLowerManip;
import poly_and_strings.StringManipulable;
import poly_and_strings.ToLowerManip;
import poly_and_strings.ToUpperManip;

public class MainWindowController {

    StringManipulable inputString;

    @FXML
    private TextField inputTextField;

    @FXML
    private TextField outputTextField;

    @FXML
    private RadioButton upperCaseToggle;

    @FXML
    private ToggleGroup caseToggleGroup;

    @FXML
    private RadioButton lowerCaseToggle;

    @FXML
    private RadioButton flipCaseToggle;

    @FXML
    void initialize() {
        inputTextField.textProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
        caseToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
    }

    public void updateOutput() {
        if(caseToggleGroup.getSelectedToggle().equals(flipCaseToggle)) {
            inputString = new FlipUpperLowerManip(inputTextField.getText());
        } else if(caseToggleGroup.getSelectedToggle().equals(lowerCaseToggle)) {
            inputString = new ToLowerManip(inputTextField.getText());
        } else {
            inputString = new ToUpperManip(inputTextField.getText());
        }

        outputTextField.setText(inputString.manip());
    }

}

package view;

import arrays.ArrayTester;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import poly_and_strings.*;

public class MainWindowController {

    StringManipulable inputString;
    ArrayTester arrayTester;

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
    private TextArea arraysTextArea;

    @FXML
    private TextField arraysAmountField;

    @FXML
    void fillArrays(ActionEvent event) {
        int amount;

        try {
            amount = Integer.valueOf(arraysAmountField.getText());
        } catch (NumberFormatException e) {
            System.out.println("NOT A NUMBER");
            return;
        }

        arrayTester = new ArrayTester(amount);
        arraysTextArea.setText(arrayTester.toString());
    }

    @FXML
    void reverseArrays(ActionEvent event) {
        if(arrayTester != null) {
            arrayTester.reverse();
            arraysTextArea.appendText(arrayTester.toString());
        }
    }

    @FXML
    void sortArrays(ActionEvent event) {
        if(arrayTester != null) {
            arrayTester.sort();
            arraysTextArea.appendText(arrayTester.toString());
        }
    }


    @FXML
    void initialize() {
        inputTextField.textProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
        caseToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
    }

    public void updateOutput() {
        if(caseToggleGroup != null && caseToggleGroup.getSelectedToggle() != null) {
            if (caseToggleGroup.getSelectedToggle().equals(flipCaseToggle)) {
                inputString = new FlipUpperLowerManip(inputTextField.getText());
            } else if (caseToggleGroup.getSelectedToggle().equals(lowerCaseToggle)) {
                inputString = new ToLowerManip(inputTextField.getText());
            } else {
                inputString = new ToUpperManip(inputTextField.getText());
            }
        } else {
            inputString = new ToLowerManip(inputTextField.getText());
        }

        outputTextField.setText(inputString.manip());
    }

}

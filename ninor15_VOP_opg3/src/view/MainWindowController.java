package view;

import arrays.ArrayTester;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import poly_and_strings.*;
import urban_population.UrbanPopulationStatistics;

import java.io.File;

public class MainWindowController {

    StringManipulable inputString;
    ArrayTester arrayTester;
    UrbanPopulationStatistics urbanPopulationStatistics;
    StringProperty fileChosen;

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
    private TextArea urbanTextArea;

    @FXML
    private TextField fileChosenTextField;

    @FXML
    void chooseFileClicked(ActionEvent event) {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text based files", "*.txt"));
        File chosenFile = chooser.showOpenDialog(null);
        if(chosenFile != null) {
            fileChosen.setValue(chosenFile.getAbsolutePath());
        }
    }

    @FXML
    void runClicked(ActionEvent event) {
        urbanPopulationStatistics = new UrbanPopulationStatistics(fileChosen.getValue());
        urbanTextArea.setText(urbanPopulationStatistics.toString());
    }

    @FXML
    void fillArrays(ActionEvent event) {
        int amount;

        try {
            amount = Integer.valueOf(arraysAmountField.getText());
        } catch (NumberFormatException e) {
            System.out.println("NOT A NUMBER");
            arraysTextArea.setText("Invalid number");
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
        } else {
            arraysTextArea.setText("Fill the array first");
        }
    }

    @FXML
    void sortArrays(ActionEvent event) {
        if(arrayTester != null) {
            arrayTester.sort();
            arraysTextArea.appendText(arrayTester.toString());
        } else {
            arraysTextArea.setText("Fill the array first");
        }
    }


    @FXML
    void initialize() {
        inputTextField.textProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
        caseToggleGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {updateOutput();});
        fileChosen = new SimpleStringProperty();
        fileChosen.addListener((observable, oldValue, newValue) -> {fileChosenTextField.setText(newValue);});
        fileChosen.setValue("ByBefolkning.txt");
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

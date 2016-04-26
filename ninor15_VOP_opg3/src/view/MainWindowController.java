package view;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MainWindowController {

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

}

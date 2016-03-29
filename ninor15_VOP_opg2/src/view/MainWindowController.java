package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import opg2_numberplates.NumberPlates;

/**
 * Created 3/29/16
 *
 * @author Niels Norberg
 */
public class MainWindowController {
    @FXML
    private TextField plateTextField;

    @FXML
    private Text plateResultText;

    @FXML
    void plateSearchButtonClicked(ActionEvent event) {
        NumberPlates numberPlates = new NumberPlates();
        plateResultText.setText(numberPlates.validate(plateTextField.getText()));
    }

}

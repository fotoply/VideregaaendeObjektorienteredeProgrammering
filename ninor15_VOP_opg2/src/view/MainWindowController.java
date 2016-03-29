package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.text.Text;
import opg2_numberplates.NumberPlates;
import opg4_population.TownStatistics;

/**
 * Created 3/29/16
 *
 * @author Niels Norberg
 */
public class MainWindowController {
    private NumberPlates numberPlates;
    private TownStatistics townStatistics;

    @FXML
    private TextField plateTextField;

    @FXML
    private Text plateResultText;

    @FXML
    private TextArea populationTextField;

    @FXML
    void populationClearClicked(ActionEvent event) {
        populationTextField.clear();
    }

    @FXML
    void populationReadFileClicked(ActionEvent event) {
        populationTextField.setText(townStatistics.toString());
    }

    @FXML
    void populationSortClicked(ActionEvent event) {
        townStatistics.sort();
        populationTextField.appendText(townStatistics.toString());
    }

    @FXML
    void plateSearchButtonClicked(ActionEvent event) {
        plateResultText.setText(numberPlates.validate(plateTextField.getText()));
    }

    @FXML
    void initialize() {
        numberPlates = new NumberPlates();
        townStatistics = new TownStatistics();
        townStatistics.readFile("Befolkning.txt");
    }

}

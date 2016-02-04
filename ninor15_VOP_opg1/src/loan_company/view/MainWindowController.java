package loan_company.view;/**
 * Created 2/3/16
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import loan_company.model.LoanDriver;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainWindowController extends Application {

    Stage primaryStage;
    LoanDriver driver = new LoanDriver();
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

    public static void main(String[] args) {
        launch(args);
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

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainWindow.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();

    }
}

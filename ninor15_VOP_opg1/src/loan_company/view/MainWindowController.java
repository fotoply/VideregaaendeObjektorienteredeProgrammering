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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class MainWindowController extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField amountTextField;

    @FXML
    private ToggleGroup typeToggleGroup;

    @FXML
    private ToggleGroup durationToggleGroup;

    @FXML
    void openFileClicked(ActionEvent event) {
        FileChooser openFileDialog = new FileChooser();
        File file = openFileDialog.showOpenDialog(primaryStage);
    }

    @FXML
    void saveToFileClicked(ActionEvent event) {

    }

    Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("MainWindow.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();

    }
}

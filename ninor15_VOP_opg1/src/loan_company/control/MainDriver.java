package loan_company.control;/**
 * Created 2/4/16
 *
 * @author Niels Norberg
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainDriver extends Application {

    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/MainWindow.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();

    }
}

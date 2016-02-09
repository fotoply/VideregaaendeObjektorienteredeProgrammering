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

    public static int loanID = 123123123;
    private static LoanDriver instance;
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    public static LoanDriver getDriverInstance() {
        if(instance == null) {
            instance = new LoanDriver();
        }
        return instance;
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

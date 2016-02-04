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
    private static MainDriver INSTANCE;
    Stage primaryStage;
    LoanDriver driver = new LoanDriver();

    public static void main(String[] args) {
        launch(args);
    }

    public static MainDriver getINSTANCE() {
        return INSTANCE;
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        MainDriver.INSTANCE = this;
        this.primaryStage = primaryStage;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/MainWindow.fxml"));
        primaryStage.setScene(new Scene(loader.load()));
        primaryStage.show();

    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public LoanDriver getDriver() {
        return driver;
    }
}

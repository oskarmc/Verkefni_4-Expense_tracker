package is.verkefni4expensetracker.vidmot.Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrackerApplication.class.getResource("/is/verkefni4expensetracker/adal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Expense tracker");
        stage.setScene(scene);
        stage.show();
    }
}

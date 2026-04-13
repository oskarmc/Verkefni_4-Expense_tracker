package is.verkefni4expensetracker.vidmot.Application;

import is.verkefni4expensetracker.vidmot.Switcher.ViewSwitcher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TrackerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrackerApplication.class.getResource("/is/verkefni4expensetracker/adal-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 400);
        scene.getStylesheets().add(
                TrackerApplication.class.getResource("/is/verkefni4expensetracker/main.css").toExternalForm()
        );
        ViewSwitcher.setScene(scene);
        stage.setTitle("Expense tracker");
        stage.setScene(scene);
        stage.show();
    }
}

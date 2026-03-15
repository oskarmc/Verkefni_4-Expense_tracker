package is.verkefni4expensetracker.vidmot.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AdalController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}

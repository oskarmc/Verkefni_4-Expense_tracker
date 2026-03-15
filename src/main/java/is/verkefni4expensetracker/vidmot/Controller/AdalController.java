package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Expense;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class AdalController {
    @FXML
    private ListView<Expense> fxListi;

    @FXML
    private Button fxNyttFlokk;

    @FXML
    private Button fxEydaFlokk;
}

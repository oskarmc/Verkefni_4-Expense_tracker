package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FaerslaDialogController {
    @FXML
    private TextField fxLysing;

    @FXML
    private TextField fxUppaed;

    @FXML
    private TextField fxDagsetning;

    public Transaction getTransaction(){
        return new Transaction(fxLysing.getText(), Integer.parseInt(fxUppaed.getText()), fxDagsetning.getText());
    }
}

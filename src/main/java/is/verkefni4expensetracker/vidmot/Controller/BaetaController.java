package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Category;
import is.verkefni4expensetracker.vinnsla.CategoryList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class BaetaController {
    @FXML
    private TextField fxNafnFlokk;

    @FXML
    private TextArea fxUppFlokk;

    public Category getCategory() {
        return new Category(fxNafnFlokk.getText(), fxUppFlokk.getText());
    }
}

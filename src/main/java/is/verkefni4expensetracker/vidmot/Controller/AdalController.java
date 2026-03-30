package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Category;
import is.verkefni4expensetracker.vinnsla.CategoryList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class AdalController {
    //FXML
    @FXML
    private ListView<Category> fxListi;

    @FXML
    private Button fxNyttFlokk;

    @FXML
    private Button fxEydaFlokk;

    @FXML
    private Button fxSkodaFlokk;

    private final CategoryList categoryList = CategoryList.getInstance();

    @FXML
    private void initialize() {
        fxListi.setItems(categoryList.getCategories());

        fxSkodaFlokk.disableProperty().bind(
                fxListi.getSelectionModel().selectedItemProperty().isNull()
        );

        fxEydaFlokk.disableProperty().bind(
                fxListi.getSelectionModel().selectedItemProperty().isNull()
        );
    }

    public void onNyttFlokk(ActionEvent actionEvent) {
        BaetaDialogWrapper.birtaDialog(
                fxListi.getScene().getWindow()
        ).ifPresent(category -> categoryList.addCategory(category));
    }

    public void onEydaFlokk() {
        Category valin = fxListi.getSelectionModel().getSelectedItem();
        categoryList.removeCategory(valin);
    }
}

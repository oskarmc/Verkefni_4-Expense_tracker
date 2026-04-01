package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vidmot.Switcher.View;
import is.verkefni4expensetracker.vidmot.Switcher.ViewSwitcher;
import is.verkefni4expensetracker.vinnsla.Category;
import is.verkefni4expensetracker.vinnsla.Transaction;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FlokkurController implements GognInterface<Category> {
    @FXML
    private Label fxNafnFlokks;

    @FXML
    private Label fxLysing;

    @FXML
    private TableView<Transaction> fxFaerslur;

    @FXML
    private TableColumn<Transaction, String> fxLysingDalkur;

    @FXML
    private TableColumn<Transaction, Integer> fxUppaedDalkur;

    @FXML
    private TableColumn<Transaction, String> fxDagsetningDalkur;

    @FXML
    private Button fxEydaFaerslu;

    private Category category;


    @FXML
    private void initialize() {
        fxLysingDalkur.setCellValueFactory(new PropertyValueFactory<>("description"));
        fxUppaedDalkur.setCellValueFactory(new PropertyValueFactory<>("amount"));
        fxDagsetningDalkur.setCellValueFactory(new PropertyValueFactory<>("date"));

        fxEydaFaerslu.disableProperty().bind(
                fxFaerslur.getSelectionModel().selectedItemProperty().isNull()
        );
    }

    @Override
    public void setGogn(Category category) {
        this.category = category;
        fxNafnFlokks.textProperty().unbind();
        fxLysing.textProperty().unbind();
        fxNafnFlokks.textProperty().bind(category.nameOfCategoryProperty());
        fxLysing.textProperty().bind(category.descriptionProperty());
        fxFaerslur.setItems(category.getTransactions());
    }

    @FXML
    private void onTilBaka() {
        ViewSwitcher.switchTo(View.ADAL, true, null);
    }

    @FXML
    private void onBaetaFaerslu() {
        FaerslaDialogWrapper.birtaDialog(
                fxFaerslur.getScene().getWindow()
        ).ifPresent(transaction -> category.addTransaction(transaction));
    }

    @FXML
    private void onEydaFaerslu() {
        Transaction valin = fxFaerslur.getSelectionModel().getSelectedItem();
        if(valin != null) {
            category.removeTransaction(valin);
        }
    }
}

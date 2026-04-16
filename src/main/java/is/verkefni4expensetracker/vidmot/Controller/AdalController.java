package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vidmot.Switcher.View;
import is.verkefni4expensetracker.vidmot.Switcher.ViewSwitcher;
import is.verkefni4expensetracker.vinnsla.Category;
import is.verkefni4expensetracker.vinnsla.CategoryList;
import is.verkefni4expensetracker.vinnsla.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class AdalController {
    //FXML
    @FXML
    private Label fxSummaLabel;

    @FXML
    private ListView<Category> fxListi;

    @FXML
    private Button fxNyttFlokk;

    @FXML
    private Button fxEydaFlokk;

    @FXML
    private Button fxSkodaFlokk;

    @FXML
    private Menu fxFlokkar;

    private final CategoryList categoryList = CategoryList.getInstance();


    @FXML
    private void initialize() {
        fxListi.setItems(categoryList.getCategories());
        updateSumma();

        // Listen for new/removed categories
        categoryList.getCategories().addListener((javafx.collections.ListChangeListener<Category>) change -> {
            updateSumma();
            // Add transaction listener to any newly added category
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Category c : change.getAddedSubList()) {
                        c.getTransactions().addListener(
                                (javafx.collections.ListChangeListener<Transaction>) t -> updateSumma()
                        );
                        addFlokkToMenu(c);
                    }
                }

                if(change.wasRemoved()) {
                    for (Category c : change.getRemoved()) {
                        removeFlokkFromMenu(c);
                    }
                }
            }
        });

        // Add transaction listener to existing categories and menubar
        for (Category c : categoryList.getCategories()) {
            c.getTransactions().addListener(
                    (javafx.collections.ListChangeListener<Transaction>) t -> {
                        updateSumma();
                        fxListi.refresh();
                    }
            );
            addFlokkToMenu(c);
        }

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

    @FXML
    private void onSkodaFlokk() {
        Category valin = fxListi.getSelectionModel().getSelectedItem();
        ViewSwitcher.switchTo(View.FLOKKUR, false, valin);
    }

    private void updateSumma() {
        int total = CategoryList.getInstance().getCategories().stream()
                .mapToInt(Category::getTotalSum).sum();
        fxSummaLabel.setText(total + " kr");
    }

    private void addFlokkToMenu(Category category) {
        MenuItem item = new MenuItem();

        item.textProperty().bind(category.nameOfCategoryProperty());

        item.setUserData(category);

        item.setOnAction(event -> {
            ViewSwitcher.switchTo(View.FLOKKUR, false, category);
        });

        fxFlokkar.getItems().add(item);
    }

    private void removeFlokkFromMenu(Category category) {
        fxFlokkar.getItems().removeIf(item ->
                item.getUserData() == category);
    }

}

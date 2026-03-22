package is.verkefni4expensetracker.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryList {
    private static final CategoryList instance = new CategoryList();

    private ObservableList<Category> transactions = FXCollections.observableArrayList();
}

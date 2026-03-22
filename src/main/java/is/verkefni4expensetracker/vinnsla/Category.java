package is.verkefni4expensetracker.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Category {
    private StringProperty nameOfCategory = new SimpleStringProperty();

    private ObservableList<Transaction> transactions = FXCollections.observableArrayList();

    public Category(String nameOfCategory) {
        this.nameOfCategory.set(nameOfCategory);
    }


}

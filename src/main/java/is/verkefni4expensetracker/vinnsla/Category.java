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

    public StringProperty nameOfCategoryProperty() { return nameOfCategory; }

    public String getNameOfCategory() { return nameOfCategory.get(); }

    public void setNameOfCategory(String nameOfCategory) { this.nameOfCategory.set(nameOfCategory); }

    public ObservableList<Transaction> getTransactions() { return transactions; }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void removeTransaction(Transaction transaction) {
        transactions.remove(transaction);
    }

    public int getTotalSum() {
        return transactions.stream().mapToInt(Transaction::getAmount).sum();
    }

    @Override
    public String toString() {return nameOfCategory.get() + " - " + getTotalSum() + "kr";}

}

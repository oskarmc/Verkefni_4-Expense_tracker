package is.verkefni4expensetracker.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Category {
    private final StringProperty nameOfCategory = new SimpleStringProperty();

    private final StringProperty description = new SimpleStringProperty();


    private final ObservableList<Transaction> transactions = FXCollections.observableArrayList();



    public StringProperty nameOfCategoryProperty() { return nameOfCategory; }

    public StringProperty descriptionProperty() { return description; }


    public String getNameOfCategory() { return nameOfCategory.get(); }

    public void setNameOfCategory(String nameOfCategory) { this.nameOfCategory.set(nameOfCategory); }


    public String getDescription() { return description.get(); }

    public void setDescription(String description) { this.description.set(description); }


    public ObservableList<Transaction> getTransactions() { return transactions; }


    public Category(String name, String description) {
        this.nameOfCategory.set(name);
        this.description.set(description);
    }

    public Category(String name) { this(name, ""); }

    public Category() { this("", ""); }


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

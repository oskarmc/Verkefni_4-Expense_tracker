package is.verkefni4expensetracker.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction {
    private StringProperty description = new SimpleStringProperty();

    private IntegerProperty amount = new SimpleIntegerProperty();

    private StringProperty date = new SimpleStringProperty();

    // Constructors
    public Transaction(String description, int amount, String date) {
        this.description = new SimpleStringProperty(description);
        this.amount = new SimpleIntegerProperty(amount);
        this.date = new SimpleStringProperty(date);
    }

    public Transaction() {
        this("",0,"");
    }

    // Properties
    public StringProperty descriptionProperty() { return description; }

    public IntegerProperty amountProperty() { return amount; }

    public StringProperty dateProperty() { return date; }

    public String getDescription() { return description.get(); }

    public void setDescription(String description) { this.description.set(description); }

    public int getAmount() { return amount.get(); }

    public void setAmount(int amount) { this.amount.set(amount); }

    public String getDate() { return date.get(); }

    public void setDate(String date) { this.date.set(date); }
}

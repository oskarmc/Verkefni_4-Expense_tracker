package is.verkefni4expensetracker.vinnsla;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Expense {
    private final StringProperty category = new SimpleStringProperty();

    private final IntegerProperty spent =  new SimpleIntegerProperty();

    public Expense(String category, int spent) {
        this.category.set(category);
        this.spent.set(spent);
    }

    public Expense() { this("", 0); }

    // Getters og setter
    public String getCategory() { return category.get(); }

    public int getSpent() {return spent.get(); }

    public void setCategory(String category) { this.category.set(category); }

    public void setSpent(int spent) { this.spent.set(spent); }

    @Override
    public String toString() { return category.get() + " - " + spent.get(); }
}

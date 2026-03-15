package is.verkefni4expensetracker.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExpenseList {
    private static final ExpenseList instance = new ExpenseList();

    private final ObservableList<Expense> expenseCategories = FXCollections.observableArrayList();

    public ObservableList<Expense> getExpenses() {
        return expenseCategories;
    }

    public static ExpenseList getInstance() {return instance;}

    public void addCategory(Expense expense) {
        expenseCategories.add(expense);
    }

    public void removeCategory(Expense expense) {
        expenseCategories.remove(expense);
    }
}

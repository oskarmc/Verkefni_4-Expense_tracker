package is.verkefni4expensetracker.vinnsla;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CategoryList {
    private static final CategoryList instance = new CategoryList();

    private ObservableList<Category> categories = FXCollections.observableArrayList();

    private CategoryList(){
        Category food = new Category("Food");
        food.addTransaction(new Transaction("Kaupmatur", 4000, "01.03.2002"));
        categories.add(food);
    }

    public static CategoryList getInstance(){ return instance; }

    public ObservableList<Category> getCategories() {
        return categories;
    }

    public void addCategory(Category c) { categories.add(c); }

    public void removeCategory(Category c) {  categories.remove(c); }
}

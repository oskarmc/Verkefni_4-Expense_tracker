module is.verkefni4expensetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.verkefni4expensetracker to javafx.fxml;
    exports is.verkefni4expensetracker;
}
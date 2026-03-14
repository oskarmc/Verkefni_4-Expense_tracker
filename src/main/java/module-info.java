module is.verkefni4expensetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.verkefni4expensetracker to javafx.fxml;
    exports is.verkefni4expensetracker;
    exports is.verkefni4expensetracker.Application;
    opens is.verkefni4expensetracker.Application to javafx.fxml;
    exports is.verkefni4expensetracker.Controller;
    opens is.verkefni4expensetracker.Controller to javafx.fxml;
}
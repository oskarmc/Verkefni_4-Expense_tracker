module is.verkefni4expensetracker {
    requires javafx.controls;
    requires javafx.fxml;


    opens is.verkefni4expensetracker to javafx.fxml;
    exports is.verkefni4expensetracker.vidmot.Application;
    opens is.verkefni4expensetracker.vidmot.Application to javafx.fxml;
    exports is.verkefni4expensetracker.vidmot.Controller;
    opens is.verkefni4expensetracker.vidmot.Controller to javafx.fxml;
    exports is.verkefni4expensetracker.vinnsla;
    opens is.verkefni4expensetracker.vinnsla to javafx.fxml;
}
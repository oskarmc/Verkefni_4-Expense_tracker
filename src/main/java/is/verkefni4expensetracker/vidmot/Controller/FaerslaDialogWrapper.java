package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Window;

import java.util.Optional;

public class FaerslaDialogWrapper {
    public static Optional<Transaction> birtaDialog(Window owner) {
        FXMLLoader loader = new FXMLLoader(
                FaerslaDialogWrapper.class.getResource("/is/verkefni4expensetracker/transaction-dialog.fxml")
        );
        DialogPane pane;
        try {
            pane = loader.load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        FaerslaDialogController controller = loader.getController();

        Dialog<Transaction> dialog = new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.initOwner(owner);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Nýr færsla");

        dialog.setResultConverter(buttonType -> {
            if (buttonType == ButtonType.OK) {
                return controller.getTransaction();
            }
            return null;
        });
        return dialog.showAndWait();
    }
}

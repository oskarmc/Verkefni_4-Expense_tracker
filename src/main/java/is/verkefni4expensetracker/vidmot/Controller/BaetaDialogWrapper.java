package is.verkefni4expensetracker.vidmot.Controller;

import is.verkefni4expensetracker.vinnsla.Category;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.stage.Modality;
import javafx.stage.Window;

import java.io.IOException;
import java.util.Optional;

public class BaetaDialogWrapper {
    public static Optional<Category> birtaDialog(Window owner) {
        FXMLLoader loader = new FXMLLoader(
                BaetaDialogWrapper.class.getResource("/is/verkefni4expensetracker/baeta-dialog.fxml")
        );
        DialogPane pane;
        try {
            pane = loader.load();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        BaetaController controller = loader.getController();

        Dialog<Category> dialog = new Dialog<>();
        dialog.setDialogPane(pane);
        dialog.initOwner(owner);
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Nýr flokkur");

        dialog.setResultConverter(buttonType -> {
            if(buttonType == ButtonType.OK) {
                return controller.getCategory();
            }
            return null;
        });
        return dialog.showAndWait();
    }
}

/*
package is.verkefni4expensetracker.vidmot.Switcher;

import is.verkefni4expensetracker.vidmot.Switcher.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ViewSwitcher {

    // Núverandi sena
    private static Scene scene;

    // Cache fyrir hlaðin viðmót
    private static final Map<View, Parent> cache = new HashMap<>();

    // Cache fyrir controllera
    private static final Map<View, Object> controllers = new HashMap<>();

    public static void setScene(Scene scene){
        ViewSwitcher.scene = scene;
    }

    public static void switchTo(View view, boolean isCache, Object gogn){
        Parent root = null;

        if(isCache && cache.containsKey(view)){
            root = cache.get(view);
        } else{
            try {
                FXMLLoader loader = new FXMLLoader(
                        ViewSwitcher.class.getResource("/is/" + view.getFileName())
                );
                root = loader.load();
                cache.put(view, root);
                controllers.put(view, loader.getController());
            } catch(IOException e){
                e.printStackTrace();
                System.out.println("Failed to load: " + view.getFileName());
                System.out.println("Resource URL: " + ViewSwitcher.class.getResource("/is/" + view.getFileName()));
            }
        }

        if(gogn != null){
            Object controller = controllers.get(view);
            if(controller instanceof GognInterface<?>){
                ((GognInterface) controller).setGogn(gogn);
            }
        }

        scene.setRoot(root);
    }

    public static Object lookup(View view){
        return controllers.get(view);
    }
}
*/
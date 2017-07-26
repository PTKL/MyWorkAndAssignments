
package multiplescreens.util;

import java.net.URL;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import multiplescreens.controller.AbstractController;

/**
 *
 * @author emil
 */
public class JavaFxUtils {
    public static FXMLLoader getFxmlLoader(String fxmlFile) {
        URL resource = IoTools.getResourceUrl(fxmlFile);
        return new FXMLLoader(resource);
    }
    
    
}

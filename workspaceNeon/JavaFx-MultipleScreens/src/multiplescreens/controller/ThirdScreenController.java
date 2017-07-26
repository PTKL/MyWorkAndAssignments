
package multiplescreens.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author emil
 */
public class ThirdScreenController  implements Initializable {
    @FXML
    private Button homeButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToHome(ActionEvent event) {
        //screensControler.loadScreen("fxml/MainScreen.fxml");
    }
    
}

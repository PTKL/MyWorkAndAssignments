
package multiplescreens.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import multiplescreens.MultipleScreensMain;
import multiplescreens.util.JavaFxUtils;

/**
 *
 * @author emil
 */
public class FirstScreenController  implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private Button secondScreenButton;
    
         
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void goToSeconScreen(ActionEvent event) {
        //screensControler.loadScreen("fxml/SecondScreen.fxml");
    }
    

  
    
}

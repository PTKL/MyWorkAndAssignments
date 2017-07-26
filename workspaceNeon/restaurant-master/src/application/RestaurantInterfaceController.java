package application;

import javafx.fxml.FXML;
import javafx.scene.control.*;

/**
 * 
 * @author emil
 *
 */
public class RestaurantInterfaceController {

  public ListView<String> CurrentMenuListView = new ListView<String>();

  @FXML
  public void CreateMenuController() {
    Main.stages.get(0).setScene(Main.scenes.get(10));
    Main.stages.get(0).show();
  }


  public void EditButtonController() {
    Main.stages.get(1).show();
  }

  public void TablesListButtonController() {
    Main.stages.get(1).show();
  }

  public void TablesOrderController() {
    Main.stages.get(1).show();
  }



}



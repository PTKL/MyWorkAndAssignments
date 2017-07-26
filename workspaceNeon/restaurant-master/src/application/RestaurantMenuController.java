package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.*;

/**
 * 
 * @author emil
 *
 */

public class RestaurantMenuController {
  public static int id;
  public static Label foodNameText = new Label();
  public TextField foodNum;
  public TextField tableCode;
  public TextArea addNote;
  String foodNumString;
  String addNoteString;



  @FXML
  public void menuController() {

    Main.stages.get(1).setScene(Main.scenes.get(13));
    Main.stages.get(1).show();

  }



  @FXML
  public void BackButtonController() {
    Main.stages.get(0).setScene(Main.scenes.get(1));
    Main.stages.get(0).show();
  }



  @FXML
  public void OrderButtonController() {
    foodNumString = foodNum.getText();
    addNoteString = addNote.getText();

  }



}

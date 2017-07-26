package application;


import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * 
 * @author emil
 *
 */
public class LoginScreenController {
  @FXML
  private TextField TextFieldFx;

  @FXML
  private PasswordField PassFieldFx;


  @SuppressWarnings("unused")
  @FXML

  public void LogInButtonController() {
    String password = (PassFieldFx.getText());
    String username = (TextFieldFx.getText());

    if (username.contains("@")) {
      Main.stages.get(1).setScene(Main.scenes.get(1));
      Main.stages.get(1).show();
    } else if (username.contains("1")) {
      Main.stages.get(1).setScene(Main.scenes.get(2));
      Main.stages.get(1).show();
    }


  }


  @FXML
  public void TextFieldController() {
    Main.stages.get(0).setScene(Main.scenes.get(1));
    Main.stages.get(0).show();
  }

  @FXML
  public void PasswordFieldController() {
    Main.stages.get(0).setScene(Main.scenes.get(1));
    Main.stages.get(0).show();
  }



}

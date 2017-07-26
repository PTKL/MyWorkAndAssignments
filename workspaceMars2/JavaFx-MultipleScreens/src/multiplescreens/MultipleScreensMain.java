
package multiplescreens;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import multiplescreens.controller.AbstractController;
import multiplescreens.controller.MainViewController;
import multiplescreens.util.JavaFxUtils;

/**
 *
 * @author emil
 */
public class MultipleScreensMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        //
       // MainViewController mainController = new MainViewController();
        // mainContainer.loadScreen("fxml/MainView.fxml");
        FXMLLoader myLoader = JavaFxUtils.getFxmlLoader("MainView.fxml");
        Parent node = (Parent)myLoader.load();
    //    Group root = new Group();
//        node.getChildren().addAll(mainController);
        Scene scene = new Scene(node, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /*   public static Parent getParent(FXMLLoader loader) {
     try {
     Parent parent = (Parent) loader.load();
     AbstractController controller = loader.getController();
     screensController.addScreen(parent, controller);
     return parent;
     } catch (IOException e) {
     e.printStackTrace();
     }
     return null;
     }
     */
    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

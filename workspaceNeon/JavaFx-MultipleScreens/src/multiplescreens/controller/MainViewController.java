package multiplescreens.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import multiplescreens.ScreensController;

/**
 * FXML Controller class
 *
 * @author emil
 */
public class MainViewController extends AnchorPane implements Initializable {

    private final static ScreensController screensControler = new ScreensController();

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu scheduleJobMenu;
    @FXML
    private MenuItem todaysScheduleMenu;
    @FXML
    private MenuItem scheduleJobEventsSearchMenu;
    @FXML
    private MenuItem searchScheduleJobsMenu;
    @FXML
    private MenuItem newScheduleJob;
    @FXML
    private Menu batchOrderMenu;
    @FXML
    private MenuItem searchBatchOrdersMenu;
    @FXML
    private Menu helpMenu;
    @FXML
    private MenuItem aboutMenu;
    @FXML
    private AnchorPane mainAnchorPane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void getScheduleBatchJobsForToday(ActionEvent event) {
        loadMainView("FirstScreen.fxml");
    }

    @FXML
    private void searchScheduleEvents(ActionEvent event) {
        loadMainView("SecondScreen.fxml");
    }

    @FXML
    private void searchScheduleJobs(ActionEvent event) {
        loadMainView("ThirdScreen.fxml");
    }

    @FXML
    private void createNewScheduleJob(ActionEvent event) {
    }

    @FXML
    private void searchBatchOrders(ActionEvent event) {
    }

    @FXML
    private void about(ActionEvent event) {
    }

    private void loadMainView(String fxmlFile) {
        System.out.println(getChildren().size());
        Node node = screensControler.loadScreen("fxml/" + fxmlFile);
        if (node != null) {
            if (!mainAnchorPane.getChildren().isEmpty()) {
                mainAnchorPane.getChildren().remove(0);
            }
            mainAnchorPane.getChildren().add(node);
        }
    }

}

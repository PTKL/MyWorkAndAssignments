package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import java.util.ArrayList;

/**
 * 
 * @author emil
 *
 */
public class Main extends Application {


	public static ArrayList<Stage> stages = new ArrayList<Stage>();
	public static ArrayList<Scene> scenes = new ArrayList<Scene>();
	public ImageView cashImage;
	public ImageView CreditCardImage;

	@Override
	public void start(Stage primaryStage){
		
		
		Stage mainStage = new Stage();
		mainStage.setTitle("Project");
		Stage stageReservation = new Stage();
		Stage stageError = new Stage();
		stages.add(mainStage);
		stages.add(stageReservation);
		stages.add(stageError);

		try {
			FXMLLoader LoginScreen = new FXMLLoader(Main.class.getResource("LoginScreen.fxml"));
			FXMLLoader RestaurantMenu = new FXMLLoader(Main.class.getResource("RestaurantMenu.fxml"));
	        FXMLLoader RestaurantInterface = new FXMLLoader(Main.class.getResource("RestaurantInterface.fxml"));


			AnchorPane LoginScreenPage = (AnchorPane) LoginScreen.load();
			AnchorPane RestaurantMenuPage = (AnchorPane) RestaurantMenu.load();
			AnchorPane RestaurantInterfacePage = (AnchorPane) RestaurantInterface.load();

			Scene LoginScreenScene = new Scene(LoginScreenPage);
			Scene RestaurantMenuScene = new Scene(RestaurantMenuPage);
	        Scene RestaurantInterfaceScene = new Scene(RestaurantInterfacePage);


			scenes.add(LoginScreenScene); // 0
			scenes.add(RestaurantMenuScene); // 1
			scenes.add(RestaurantInterfaceScene); // 2

			mainStage.setScene(LoginScreenScene);
			mainStage.show();

		} catch (IOException e) {
			System.err.println("Error!");
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}



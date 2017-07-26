package clickFX;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.application.Application;

public class Click extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	GraphicsContext gc;
	ClickData clickData;
	int squareSize;
	Stage primaryStage;
	Color colours[] = { Color.WHITE, Color.RED, Color.GREEN, Color.CYAN,
			Color.BLUE, Color.BLACK, Color.PURPLE, Color.YELLOW };

	public void start(Stage primaryStage) {
		squareSize = 20;
		int x = 20, y = 30;
		clickData = new ClickData(x, y);
		VBox root = new VBox(8);
		HBox buttons = new HBox(5);
		buttons.setAlignment(Pos.CENTER);

		Button clearButton = new Button("Clear");
		clearButton.setOnAction(new clearButtonHandler());

		Button closeButton = new Button("Close");
		closeButton.setOnAction(new closeButtonHandler());
		buttons.getChildren().addAll(clearButton, closeButton);
		Canvas canvas = new Canvas(x * squareSize, y * squareSize);
		gc = canvas.getGraphicsContext2D();
		canvas.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new mouseClickHandler());
		this.primaryStage = primaryStage;
		primaryStage.setTitle("Click me");
		root.getChildren().addAll(canvas, buttons);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	class clearButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			clickData.clear();
			gc.setFill(Color.WHITE);
			gc.fillRect(0, 0, clickData.getX() * squareSize, clickData.getY()
					* squareSize);
		}
	}

	class closeButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			primaryStage.close();
		}
	}

	class mouseClickHandler implements EventHandler<MouseEvent> {
		public void handle(MouseEvent e) {
			double x = e.getX(), y = e.getY();
			int cx = (int) x / squareSize, cy = (int) y / squareSize;
			System.out.println("Click (" + x + ", " + y + ")");
			clickData.setCell(cx, cy, clickData.getCell(cx, cy) + 1);
			gc.setFill(colours[clickData.getCell(cx, cy) % colours.length]);
			gc.fillRect(cx * squareSize, cy * squareSize, squareSize,
					squareSize);
		}
	}

	class ClickData {
		int[][] grid;

		ClickData(int x, int y) {
			grid = new int[y][x];
		}

		public int getX() {
			return grid[0].length;
		}

		public int getY() {
			return grid.length;
		}

		public int getCell(int x, int y) {
			return grid[y][x];
		}

		public void setCell(int x, int y, int v) {
			grid[y][x] = v;
		}

		public void clear() {

			for (int y = 0; y < getY(); y++)
				for (int x = 0; x < getX(); x++)
					setCell(x, y, 0);

		}
	}

}

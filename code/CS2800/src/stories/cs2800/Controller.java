package stories.cs2800;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;

import stories.cs2800.Database;
import stories.cs2800.Item;
import stories.cs2800.ItemType;
import stories.cs2800.Model;
import stories.cs2800.NullDB;
import stories.cs2800.PsqlDB;
import stories.cs2800.View;

public class Controller {
	private static Controller instance;
	private static View view;
	private Model model = Model.getModel();
	private Database db;

	private Controller.AddHoursListener hoursListener = new Controller.AddHoursListener();

	public static Controller getInstance() throws Exception {
		if (instance == null) {
			instance = new Controller();
		}

		return instance;
	}

	@SuppressWarnings("unchecked")
	private Controller() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver");
			db = new Database(new PsqlDB("emil"));
		} catch (SQLException | ClassNotFoundException exceptionSQL) {
			exceptionSQL.printStackTrace();
			db = new Database(new NullDB());
		}

		@SuppressWarnings("rawtypes")
		HashMap lists = new HashMap();
		lists.put(ItemType.PROJECT, this.model.getItems(ItemType.PROJECT));
		lists.put(ItemType.DEVELOPER, this.model.getItems(ItemType.DEVELOPER));
		lists.put(ItemType.STORY, this.model.getItems(ItemType.STORY));
		view.setAddHoursListener(this.hoursListener);
		view.setVisible(true);
	}

	private class AddHoursListener implements ActionListener {
		private AddHoursListener() {
		}

		public void actionPerformed(ActionEvent e) {
			Item developer = view.getSelectedItem(ItemType.DEVELOPER);
			Item story = view.getSelectedItem(ItemType.STORY);
			if (developer != null && story != null && story.isOpen()) {
				String prompt = "Hours for: " + developer.getName()
						+ " working on: " + story.getName();
				prompt.toString();

			}
		}

	}
}
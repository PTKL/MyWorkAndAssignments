import java.sql.*;

public class Bank {
	private Connection dbConn;

	public Bank(String url, String username, String password)
			throws SQLException {
		dbConn = DriverManager.getConnection(url, username, password);
	}

	public void getInfo(int custID) throws SQLException {
		PreparedStatement statement = dbConn
				.prepareStatement("SELECT * FROM EmilBank WHERE Cust_ID = ?");
		statement.setInt(1, custID);
		ResultSet result = statement.executeQuery();
		result.next();
		System.out.println(result.getString("Cust_Name"));
		System.out.println(result.getString("Cust_Addr"));
		System.out.println(result.getString("Balance"));
	}

	public void deposit(int custID, double ammount) throws SQLException {
		PreparedStatement statement = dbConn.prepareStatement("UPDATE EmilBank "
				+ "SET Balance = Balance + ? WHERE Cust_ID = ?");
		statement.setDouble(1, ammount);
		statement.setInt(2, custID);
		statement.executeUpdate();
	}

	public void withdraw(int custID, double ammount) throws SQLException {
		PreparedStatement statement = dbConn.prepareStatement("UPDATE EmilBank "
				+ "SET Balance = Balance - ? WHERE Cust_ID = ?");
		statement.setDouble(1, ammount);
		statement.setInt(2, custID);
		statement.executeUpdate();
	}
}

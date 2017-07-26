import java.sql.*;

public class TestDB {

	private final static String dbHost = "db4free.net";
	private final static String dbName = "rhulcompsoc";
	private final static String dbUser = "rhulcompsoc";
	private final static String dbPass = "compsocpass123";

	public static void main(String[] args) throws SQLException {

		Connection dbConn = DriverManager.getConnection("jdbc:mysql://"
				+ dbHost + "/" + dbName, dbUser, dbPass);

		Statement statement = dbConn.createStatement();

		ResultSet result = statement.executeQuery("SELECT * FROM EmilBank");

		result.next();

		System.out.println(result.getString("Cust_Name"));
		System.out.println(result.getString("Cust_Addr"));
		System.out.println(result.getString("Balance"));
	}

}

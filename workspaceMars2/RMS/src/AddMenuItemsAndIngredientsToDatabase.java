import java.sql.*;
import java.io.*;

public class AddMenuItemsAndIngredientsToDatabase {
	public static void main(String [] argv) throws SQLException, FileNotFoundException{
		/** username is name of the server, where the database is hosted*/
		String username = "cimteaching1";
		/**port is port number where program can connect to the database*/
		String port = "27010";
		/**database is a name of the database*/
		String database = "teamproject";
		
		//Making connection to the database with username, port and test database. 
		Connection connection = connectToDatabase(username, port, database);
		if (connection != null) {
			System.out.println("Connection Successful!! You can control your database now!");
		} else {
			System.out.println("Failed to make connection!");
			return;
		}
		
		dropTable(connection, "menuitemsCJB");
		addTable(connection, "menuitemsCJB", "menuitem varchar(2048) primary key");
		insertIntoTableFromFile(connection, "menuitemsCJB", "menuItemsToAddToDatabase.txt");
		
		String query1 = "SELECT * FROM menuitemsCJB";
		System.out.println("\n###########MenuItems Query##########"); 
		printResult(executeSelect(connection, query1));
		
		dropTable(connection, "ingredientsCJB");
		addTable(connection, "ingredientsCJB", "stocklevel int, ingredient varchar(2048) primary key");
		insertIntoTableFromFile(connection, "ingredientsCJB", "ingredientsToAddToDatabase.txt");
		
		String query2 = "SELECT * FROM ingredientsCJB";
		System.out.println("\n###########Ingredients Query##########"); 
		printResult(executeSelect(connection, query2));	
	}
	
	/**
	 * Connection connectToDatabase takes the parameter username, port and database and loads 
	 * the postgresql.Driver. It will print the user interactive notifications when connection is made
	 * or print corresponding messages if any type of exceptions arise.
	 * @param username
	 * name of the host
	 * @param port
	 * port of the host
	 * @param database
	 * name of the database
	 * @return
	 * returns connection through which we can interact with SQL
	 */
	public static Connection connectToDatabase(String username, String port, String database) {
		System.out.println("----------PostgreSQL + JDBC Connection Testing-----------");
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your PostgreSQL JDBC Driver? Include in your library path!");
			e.printStackTrace();
		}
		System.out.println("PostgreSQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://"+username+":" + port + "/" + database);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		return connection;
	}
	
	/**
	 * dropTable takes the parameters: connection and tableName. It executes method
	 * of postgreSQL to drop the table.
	 * @param connection
	 * connection that was established with the database on the host
	 * @param tableName
	 * name of the table that will be deleted
	 */
	public static void dropTable(Connection connection, String tableName) {
		Statement st = null;
		try {
			st = connection.createStatement();
			st.execute("DROP TABLE " + tableName);
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * createTable takes the parameters: connection, tableName and tableDescription. It executes
	 * postgreSQL statement to create a new table with the provided tableName and tableDescription.
	 * @param connection
	 * connection that was established with the database on the host
	 * @param tableName
	 * name of the table that will be created
	 * @param tableDescription
	 * description of the table that will be created
	 */
	public static void createTable(Connection connection, String tableName, String tableDescription) {
		Statement st = null;
		try {
			st = connection.createStatement();
			st.execute("CREATE TABLE " + tableName + "(" + tableDescription + " ); ");
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * addTable takes the parameters: connection, tableName and tableDescription.
	 * If specified table is not already in the database it will be created.
	 * If the specified table is present in the database, it will drop the table and creates a new one.
	 * @param connection
	 * connection that was established with the database on the host
	 * @param tableName
	 * name of the table that will be created or deleted and created again
	 * @param tableDescription
	 * description of the table
	 * @throws SQLException
	 * sql exception is thrown if the connection does not exist or description provided is wrong or etc.
	 */
	public static void addTable(Connection connection, String tableName, String tableDescription) throws SQLException{
		//connection is of type connection in JDBC
		DatabaseMetaData dbm = connection.getMetaData();
						
		//Check if the table is there
		ResultSet tables = dbm.getTables(null,null,tableName, null);
		System.out.println(tableName);
		System.out.println();
		//System.out.println(tables.next());
		System.out.println();
		if(tables.next()==true){
			//The table exist
			System.out.println(tableName + " already exists.");
			dropTable(connection, tableName);
			System.out.println("Dropping the old table");
			createTable(connection, tableName, tableDescription);
			System.out.println("creating new one");
		}else {
		//table doesn't exist
			System.out.println("No tables exist prior in database. Creating new table");
			createTable(connection, tableName, tableDescription);
		}		
	}
	
	/**
	 * insertTableFromFile takes the parameters: connection, table and file. It uses BufferedReader
	 * to read the file and enter every line in the table in corresponding columns.
	 * @param connection
	 * connection that was established with the database on the host
	 * @param table
	 * name of the table where the lines from file will be inserted
	 * @param file
	 * name of the file from which lines will be inserted in the table
	 * @return
	 * returns a value corresponding to number of rows that have been inserted.
	 */
	public static int insertIntoTableFromFile(Connection connection, String table, String file) throws FileNotFoundException {
		BufferedReader br = null;
		int numRows = 0;
		try {
			Statement st = connection.createStatement();
			/**sCurrentLine is one line in the file that is read through buffer*/
			String sCurrentLine;
			/**brokenLine is an array that holds each attribute of the table*/
			String brokenLine[];
			/**composedLine combines each attribute of brokenLine array and inserts the new row in the table*/
			String composedLine = "";
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				/** 
				 * each element that was split by \t(tab) is held in brokenLine.
				 * \t is a delimiter that notes each attribute of the row
				 */
				brokenLine = sCurrentLine.split("\t"); 
				// compose each line to insert in the DB
				composedLine = "INSERT INTO "+table+" VALUES (";
				int i;
				for (i = 0; i < brokenLine.length - 1; i++) {
					composedLine += "'" + brokenLine[i] + "',";
				}
				composedLine += "'" + brokenLine[i] + "')";
				// Insert each line to the DB
				System.out.println(composedLine);
				numRows = st.executeUpdate(composedLine);
				System.out.println(composedLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return numRows;
	}
	
	/**
	 * Takes the query and connection as parameters. Executes the query and stores it in ResultSet, which is returned.
	 * @param connection
	 * connection that was established with the database on the host
	 * @param query
	 * query that will be executed
	 * @return
	 * returns a ResultSet of the query
	 */
	public static ResultSet executeSelect(Connection connection, String query) {
		Statement st = null;
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		ResultSet rs = null;
		try {
			rs = st.executeQuery(query);
			//st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return rs;
	}
	
	/**
	 * Takes the ResultSet as a parameter. It prints the results of the ResultSet.
	 * @param rs
	 * ResultSet that has been passed.
	 * @throws SQLException
	 * throws sql exception
	 */
	private static void printResult(ResultSet rs) throws SQLException{
		try {
			while(rs.next()){
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					String columnValue = rs.getString(i);
					if(columnValue!=null){
						System.out.print(columnValue);
					}
					System.out.print("\t");
				}
				System.out.print("\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}



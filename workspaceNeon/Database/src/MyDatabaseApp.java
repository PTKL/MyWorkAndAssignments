import java.sql.*;
import java.io.*;

public class MyDatabaseApp {
	
	public static void main(String[] args) throws SQLException {

		String user = "zyvb263";
		String port = "28064";
		
		// test is the name of the DB you already created last session
        String database = "test";
        
        Connection connection = connectToDatabase(user, port, database);
             
        if (connection != null) {
        	System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
            return;
        }
        
        // Now we're ready to work on the DB
        
        String query = "SELECT * FROM branch";
        ResultSet rs = executeSelect(connection, query);
        
        try {
        	while (rs.next()) {
        		System.out.print("Column 1 returned ");
        		System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
        	}
        } catch (SQLException e) {
        	e.printStackTrace();
        }
        
        rs.close();
        
        dropTable(connection, "customer");
        createTable(connection, "customer(id int primary key, name varchar(15), street varchar(15), city varchar(15));");
        int rows = insertIntoTableFromFile(connection, "customer","src/Table.txt");
	}
	
	public static Connection connectToDatabase(String user, String port, String database) {
	    
		System.out.println("-------- PostgreSQL " 
				+ "JDBC Connection Testing ------------");
		
		try {
			Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
        	
            System.out.println("Where is your PostgreSQL JDBC Driver? "
                         + "Include in your library path!");
            
            e.printStackTrace();
        }
		
		System.out.println("PostgreSQL JDBC Driver Registered!");

		Connection connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:" + port + "/" + database, user, "doesn't matter!");
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
		}
		
		return connection;
	}
	
	
	public static ResultSet executeSelect(Connection connection, String query) {
		
		Statement st = null;
		
		try {
			st = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Failed to create statement!");
			e.printStackTrace();
		}
		
		ResultSet rs = null;
		
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e) {
			System.out.println("Failed to execute query!");
			e.printStackTrace();
		}
		
		return rs;		
	}
	
	
	public static void dropTable(Connection connection, String table) {
		Statement st = null;
		
		try {
			st = connection.createStatement();
			st.execute("DROP TABLE" + table);
			st.close();
		} catch (SQLException e) {
			System.out.println("Failed to drop table!");
			e.printStackTrace();
		}	
	}
	
	public static void createTable(Connection connection, String tableDescription) {
		Statement st = null;
		
		try {
			st = connection.createStatement();
			st.execute("CREATE TABLE" + tableDescription);
			st.close();
		} catch (SQLException e) {
			System.out.println("Failed to create table!");
			e.printStackTrace();
		}	
	}
	
}

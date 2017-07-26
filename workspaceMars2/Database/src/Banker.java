import java.sql.SQLException;

public class Banker {

	public static void main(String[] args) throws SQLException {
		Bank banker = new Bank("jdbc:mysql://db4free.net/rhulcompsoc",
				"rhulcompsoc", "compsocpass123");

		banker.getInfo(2);
		banker.deposit(2, 100);
		banker.getInfo(2);
		banker.withdraw(2, 80);

	}

}

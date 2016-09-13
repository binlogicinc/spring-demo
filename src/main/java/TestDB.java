import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;




public class TestDB {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		try
		{
		String url = "jdbc:mariadb://127.0.0.1:3307/spring";
		String user = "fermin";
		String password = "123456";

		// Load the Connector/J driver
		Class.forName("org.mariadb.jdbc.Driver").newInstance();
		// Establish connection to MySQL
		Connection conn = DriverManager.getConnection(url, user, password);
		
		System.out.println(conn);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
}

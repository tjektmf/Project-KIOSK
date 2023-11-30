package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public static String driverPath = "oracle.jdbc.driver.OracleDriver";
	public static String url = "jdbc:oracle:thin:@localhost:1521:XE";
	public static String id = "dstest";
	public static String pw = "1234";

	static {
		try {
			Class.forName(driverPath);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(url, id, pw);
	}

}
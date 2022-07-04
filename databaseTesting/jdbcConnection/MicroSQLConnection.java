package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MicroSQLConnection {
	public static Connection getSQLServerConnection() {
		String hostname = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "automationfc";
		
		return getSQLServerConnection(hostname, sqlInstanceName, database, userName, password);
	}

	private static Connection getSQLServerConnection(String hostname, String sqlInstanceName, String database,
			String userName, String password) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String connectionURL = "jdbc:sqlserver://" + hostname + ":1433" + ";instance=" + sqlInstanceName + ";databaseName=" + database;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}

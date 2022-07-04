package jdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLJTDSConnection {
	public static Connection getSQLServerConnection() {
		String hostname = "localhost";
		String sqlInstanceName = "SQLEXPRESS";
		String database = "automationfc";
		String userName = "sa";
		String password = "automationfc";
		
		return getSQLServerConnection(hostname, sqlInstanceName, database, userName, password);
	}

	public static Connection getSQLServerConnection(String hostname, String sqlInstanceName, String database, String userName, String password) {
		Connection conn = null;
		try {
			// Java 6 tu dong tim kiem Driver thich hop - ko bat buoc co dong nay
//			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			
			String connectionURL = "jdbc:jtds:sqlserver://" + hostname + ":1433/" + database + ";instance=" + sqlInstanceName;
			conn = DriverManager.getConnection(connectionURL, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}

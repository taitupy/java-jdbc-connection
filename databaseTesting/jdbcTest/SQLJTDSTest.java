package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.SQLJTDSConnection;

public class SQLJTDSTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		System.out.println("Get connection...");

		Connection conn = SQLJTDSConnection.getSQLServerConnection();

		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "SELECT EMP_ID, FIRST_NAME, LAST_NAME, DEPT_ID FROM [automationfc].[dbo].[EMPLOYEE];";
		
		ResultSet rs = statement.executeQuery(sql);
		
		while(rs.next()) {
			int empId = rs.getInt(1);
			String empFirstName = rs.getString(2);
			String empLastName = rs.getString("Last_Name");
			int deptID = rs.getInt("Dept_Id");
			
			System.out.println("-----------------------");
			System.out.println("Emp Id:" + empId);
			System.out.println("Emp Firstname:" + empFirstName);
			System.out.println("Emp Lastname:" + empLastName);	
			System.out.println("Dept ID:" + deptID);
		}
		
		// Dong ket noi
		conn.close();
		System.out.println("------------Closed connection----------------------------");
	}

}

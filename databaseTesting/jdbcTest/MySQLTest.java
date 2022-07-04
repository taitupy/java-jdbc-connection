package jdbcTest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbcConnection.MySQLConnection;

public class MySQLTest {
	static Connection conn;
	
	public static void main(String[] args) throws SQLException {
		//Connection conn;
		
		conn = MySQLConnection.getMySQLConnection();
		
		System.out.println("Opened connection: " + conn);
		
		Statement statement = conn.createStatement();
		
		String sql = "Select Emp.Emp_Id, Emp.First_Name, Emp.Last_Name, Emp.Dept_Id From Employee Emp;";
		
		// Thuc thi cau lenh SQL tra ve doi tuong ResultSet
		ResultSet rs = statement.executeQuery(sql);
		
		// Duyet tren ket qua tra ve
		while(rs.next()) {
			// Di chuyen con tro xuong ban ghi ke tiep
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
		
	}

}

package task8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class TableCreation {
	public static void main(String[] args) {
		Connection con = JDBCUtility.getConnection();
		ResultSet result;
		
		try {
			
			Statement stmt = con.createStatement();
			
			//creating table
			stmt.executeUpdate("create table employee(empno integer,ename varchar(20),deptno integer)"); 
			
			//insert values into the table
			
			int row1=stmt.executeUpdate("insert into employee values (1001,'ram',100)");
			int row2=stmt.executeUpdate("insert into employee values (1002,'arun',100)");
			int row3=stmt.executeUpdate("insert into employee values (1003,'pooja',200)");
			
			
			//displaying table

			result = stmt.executeQuery("select * from employee");
			
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3));
			}
			System.out.println();
			
			
			//dynamically constructing query
			
	
			PreparedStatement updateEmployeeName;
			
			String updateEmployeeNameStr="update employee set ename=? where empno=?";
			

			updateEmployeeName = con.prepareStatement(updateEmployeeNameStr);
			

			String[] employeeName= {"Dhev","Shyam","Rohan"};
		
			
			updateEmployeeName.setString(1, employeeName[0]);
			updateEmployeeName.setInt(2, 1001);

			updateEmployeeName.executeUpdate();

			updateEmployeeName.setString(1, employeeName[1]);
			updateEmployeeName.setInt(2, 1002);

			updateEmployeeName.executeUpdate();
			
			result = stmt.executeQuery("select * from employee");
			while(result.next()) {
				System.out.println(result.getInt(1)+" "+result.getString(2)+" "+result.getInt(3));
			}
			
//			stmt.executeUpdate("drop table employee");
			
			JDBCUtility.closeConnection(null,null);
			
		
			
	
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
}

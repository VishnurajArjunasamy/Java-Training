package task8;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.xdevapi.Result;

public class TableCreation {
	public static void main(String[] args) {
		Connection connnection = JDBCUtility.getConnection();
		ResultSet result;

		try {
			Statement statement = connnection.createStatement();

			// creating table
			statement
					.executeUpdate("create table employee(empno integer PRIMARY KEY,ename varchar(20),deptno integer)");

			// insert values into the table
			int row1 = statement.executeUpdate("insert into employee values (1001,'ram',100)");
			int row2 = statement.executeUpdate("insert into employee values (1002,'arun',100)");
			int row3 = statement.executeUpdate("insert into employee values (1003,'pooja',200)");

			// displaying table
			result = statement.executeQuery("select * from employee");

			while (result.next()) {
				System.out.println(result.getInt(1) + " " + result.getString(2) + " " + result.getInt(3));
			}

			// dynamically constructing query
			PreparedStatement preparedStatement;
			String updateEmployeeNameStr = "update employee set ename=? where empno=?";
			preparedStatement = connnection.prepareStatement(updateEmployeeNameStr);
			String[] employeeName = { "Dhev", "Shyam", "Rohan" };
			preparedStatement.setString(1, employeeName[0]);
			preparedStatement.setInt(2, 1001);
			preparedStatement.executeUpdate();
			preparedStatement.setString(1, employeeName[1]);
			preparedStatement.setInt(2, 1002);
			preparedStatement.executeUpdate();
			result = statement.executeQuery("select * from employee");

//			stmt.executeUpdate("drop table employee");
			JDBCUtility.closeConnection(null, null);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

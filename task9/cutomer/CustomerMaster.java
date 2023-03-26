package task9.cutomer;

import java.sql.Connection;
import java.util.List;

import task9.JDBCUtility;


public class CustomerMaster {
	public static void main(String[] args) {
		Connection con=JDBCUtility.getConnection();
		CustomerDAO dao=CustomerDAOImpl.getPrototype();
	
		CustomerDTO dto1=dao.findByPrimaryKey(1001, con);
		
		con=JDBCUtility.getConnection();
		CustomerDTO dto2=dao.findByPrimaryKey(1002, con);
		

		con=JDBCUtility.getConnection();
		List<CustomerDTO> list=(List<CustomerDTO>) dao.findAll(con);
		System.out.println(list);
	}
}

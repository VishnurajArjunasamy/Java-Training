package task9.transaction;

import java.sql.Connection;
import java.util.List;

import task9.JDBCUtility;


public class TransactionMaster {
	public static void main(String[] args) {
		Connection con=JDBCUtility.getConnection();
		TransactionDAO dao=TransactionDAOImp.getPrototype();
	
		TransactionDTO dto1=dao.findByPrimaryKey(1001, con);
		
		con=JDBCUtility.getConnection();
		TransactionDTO dto2=dao.findByPrimaryKey(1002, con);
		

		con=JDBCUtility.getConnection();
		List<TransactionDTO> list=(List<TransactionDTO>) dao.findAll(con);
		System.out.println(list);
	}
}

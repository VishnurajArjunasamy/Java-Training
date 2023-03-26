package task9.item;

import java.sql.Connection;
import java.util.List;

import task9.JDBCUtility;


public class ItemMaster {
	public static void main(String[] args) {
		Connection con=JDBCUtility.getConnection();
		ItemDAO dao=ItemDAOImpl.getPrototype();
	
		ItemDTO dto1=dao.findByPrimaryKey(200, con);
		
		con=JDBCUtility.getConnection();
		ItemDTO dto2=dao.findByPrimaryKey(201, con);
		

		con=JDBCUtility.getConnection();
		List<ItemDTO> list=(List<ItemDTO>) dao.findAll(con);
		System.out.println(list);
	}
}

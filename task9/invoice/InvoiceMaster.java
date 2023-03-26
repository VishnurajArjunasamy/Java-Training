package task9.invoice;

import java.sql.Connection;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import task9.JDBCUtility;

public class InvoiceMaster {
	public static void main(String[] args) {
		Connection con=JDBCUtility.getConnection();
		InvoiceMasterDAO dao=InvoiceMasterDAOImpl.getPrototype();
	
		InvoiceMasterDTO dto1=dao.findByPrimaryKey(1001, con);
		
		con=JDBCUtility.getConnection();
		InvoiceMasterDTO dto2=dao.findByPrimaryKey(1002, con);
		

		con=JDBCUtility.getConnection();
		List<InvoiceMasterDTO> list=(List<InvoiceMasterDTO>) dao.findAll(con);
		System.out.println(list);
		
		
		
		
		
//		System.out.println(dto1.getAmount()+":"+dto2.getAmount());
//		
//		List<InvoiceMasterDTO> list=Arrays.asList(dto1,dto2);
//		
//		Collections.sort(list,(o1,o2)->{return o2.compareTo(o1);});
//		
//		System.out.println(list);
//		
		
	}
}

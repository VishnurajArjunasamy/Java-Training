package task9.cutomer;

import java.sql.Connection;
import java.util.Collection;


public abstract class CustomerDAO {
	public abstract CustomerDTO findByPrimaryKey(int id,Connection con);
	public abstract Collection<CustomerDTO> findByCustomerAddress(String custaddress,Connection con);
	public abstract Collection<CustomerDTO> findAll(Connection con);
	public abstract int updateCustomerDTO(CustomerDTO inv,Connection con);
	public abstract int deleteCustomerDTO(int id,Connection con);
	public abstract int save(CustomerDTO inv,Connection con);
}

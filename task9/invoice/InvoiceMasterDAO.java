package task9.invoice;

import java.sql.Connection;
import java.util.Collection;

public abstract class InvoiceMasterDAO {
	public abstract InvoiceMasterDTO findByPrimaryKey(int id,Connection con);
	public abstract Collection<InvoiceMasterDTO> findByCustomerID(int custid,Connection con);
	public abstract Collection<InvoiceMasterDTO> findAll(Connection con);
	public abstract int updateInvoiceMasterDTO(InvoiceMasterDTO inv,Connection con);
	public abstract int deleteInvoiceMasterDTO(int id,Connection con);
	public abstract int save(InvoiceMasterDTO inv,Connection con);
}

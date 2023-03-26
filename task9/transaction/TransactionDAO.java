package task9.transaction;

import java.sql.Connection;
import java.util.Collection;

public abstract class TransactionDAO {
	public abstract TransactionDTO findByPrimaryKey(int id,Connection con);
	public abstract Collection<TransactionDTO> findByItemID(int itemid,Connection con);
	public abstract Collection<TransactionDTO> findAll(Connection con);
	public abstract int updateTransactionDTO(TransactionDTO inv,Connection con);
	public abstract int deleteTransactionDTO(int id,Connection con);
	public abstract int save(TransactionDTO inv,Connection con);
}

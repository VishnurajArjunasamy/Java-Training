package task9.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import task9.JDBCUtility;

public class TransactionDAOImp extends TransactionDAO implements Cloneable {
	private TransactionDAOImp() {
		System.out.println("trancation master dao object created....");
	}

	public static TransactionDAO getMultiTon() {
		return new TransactionDAOImp();
	}

	private static TransactionDAOImp dao;

	synchronized public static TransactionDAO getSingleTon() {
		if (dao == null) {
			dao = new TransactionDAOImp();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static TransactionDAO getPrototype() {
		if (dao == null) {
			dao = new TransactionDAOImp();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public TransactionDAO getClone() {
		try {
			return (TransactionDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public TransactionDTO findByPrimaryKey(int id, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_transaction where invid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				TransactionDTO dto = TransactionDTO.getInstance();
				dto.setInvid(rs.getInt("invid"));
				dto.setItemid(rs.getInt("itemid"));
				dto.setQuantity(rs.getInt("qty"));
				dto.setPrice(rs.getInt("price"));
				JDBCUtility.closeConnection(null, null);

				return dto;
			}

			else {
				JDBCUtility.closeConnection(null, null);
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<TransactionDTO> findByItemID(int itemid, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_transaction where itemid=?");
			List<TransactionDTO> transactionList = new ArrayList<>();
			ps.setInt(1, itemid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TransactionDTO dto = TransactionDTO.getInstance();
				dto.setInvid(rs.getInt("invid"));
				dto.setItemid(rs.getInt("itemid"));
				dto.setQuantity(rs.getInt("qty"));
				dto.setPrice(rs.getInt("price"));
				transactionList.add(dto);
			}

			JDBCUtility.closeConnection(null, null);

			return transactionList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<TransactionDTO> findAll(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_transaction");
			List<TransactionDTO> transactionList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				TransactionDTO dto = TransactionDTO.getInstance();
				dto.setInvid(rs.getInt("invid"));
				dto.setItemid(rs.getInt("itemid"));
				dto.setQuantity(rs.getInt("qty"));
				dto.setPrice(rs.getInt("price"));
				transactionList.add(dto);

			}

			JDBCUtility.closeConnection(null, null);

			return transactionList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int updateTransactionDTO(TransactionDTO transaction, Connection con) {
		int status = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("update invoice_transaction set itemid=? qty=? price=? where invid=?");

			if (transaction != null) {
				ps.setInt(1, transaction.getItemid());
				ps.setInt(2, transaction.getQuantity());
				ps.setInt(3, transaction.getPrice());
				ps.setInt(4, transaction.getInvid());

				status = ps.executeUpdate();
				JDBCUtility.closeConnection(null, null);
			}

			return status;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int deleteTransactionDTO(int id, Connection con) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from invoice_transaction where invid=?");
			ps.setInt(1, id);
			int status = ps.executeUpdate();
			JDBCUtility.closeConnection(null, null);
			return status;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return 0;
		}
	}

	@Override
	public int save(TransactionDTO inv, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
}

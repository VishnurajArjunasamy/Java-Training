package task9.invoice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import task9.JDBCUtility;

public class InvoiceMasterDAOImpl extends InvoiceMasterDAO implements Cloneable {
	private InvoiceMasterDAOImpl() {
		System.out.println("invoice master dao object created....");
	}

	public static InvoiceMasterDAO getMultiTon() {
		return new InvoiceMasterDAOImpl();
	}

	private static InvoiceMasterDAOImpl dao;

	synchronized public static InvoiceMasterDAO getSingleTon() {
		if (dao == null) {
			dao = new InvoiceMasterDAOImpl();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static InvoiceMasterDAO getPrototype() {
		if (dao == null) {
			dao = new InvoiceMasterDAOImpl();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public InvoiceMasterDAO getClone() {
		try {
			return (InvoiceMasterDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InvoiceMasterDTO findByPrimaryKey(int id, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_master where invid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(rs.getInt(1));
				dto.setInvdate(rs.getDate(2));
				dto.setAmount(rs.getInt("amount"));
				dto.setDiscount(rs.getInt(5));
				dto.setCustid(rs.getInt("custid"));
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
	public Collection<InvoiceMasterDTO> findByCustomerID(int custid, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_master where custid=?");
			List<InvoiceMasterDTO> userIDList = new ArrayList<>();
			ps.setInt(1, custid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(rs.getInt(1));
				dto.setInvdate(rs.getDate(2));
				dto.setAmount(rs.getInt("amount"));
				dto.setDiscount(rs.getInt(5));
				dto.setCustid(rs.getInt("custid"));
				userIDList.add(dto);
			}

			JDBCUtility.closeConnection(null, null);

			return userIDList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<InvoiceMasterDTO> findAll(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from invoice_master");
			List<InvoiceMasterDTO> userInfoList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				InvoiceMasterDTO dto = InvoiceMasterDTO.getInstance();
				dto.setInvid(rs.getInt(1));
				dto.setInvdate(rs.getDate(2));
				dto.setAmount(rs.getInt("amount"));
				dto.setDiscount(rs.getInt(5));
				dto.setCustid(rs.getInt("custid"));
				userInfoList.add(dto);
				
			}

			JDBCUtility.closeConnection(null, null);

			return userInfoList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int updateInvoiceMasterDTO(InvoiceMasterDTO invoice, Connection con) {
		int status = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("update invoice_master set custid=? invdate=? amount=? discount=? where invid=?");

			if (invoice != null) {
				ps.setInt(1, invoice.getCustid());
				ps.setDate(2, (java.sql.Date) invoice.getInvdate());
				ps.setInt(3, invoice.getAmount());
				ps.setInt(4, invoice.getDiscount());
				ps.setInt(5, invoice.getInvid());

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
	public int deleteInvoiceMasterDTO(int id, Connection con) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from invoice_master where invid=?");
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
	public int save(InvoiceMasterDTO inv, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
}

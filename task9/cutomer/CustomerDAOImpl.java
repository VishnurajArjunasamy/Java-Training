package task9.cutomer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import task9.JDBCUtility;

public class CustomerDAOImpl extends CustomerDAO implements Cloneable {
	private CustomerDAOImpl() {
		System.out.println("customer master dao object created....");
	}

	public static CustomerDAO getMultiTon() {
		return new CustomerDAOImpl();
	}

	private static CustomerDAOImpl dao;

	synchronized public static CustomerDAO getSingleTon() {
		if (dao == null) {
			dao = new CustomerDAOImpl();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static CustomerDAO getPrototype() {
		if (dao == null) {
			dao = new CustomerDAOImpl();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public CustomerDAO getClone() {
		try {
			return (CustomerDAO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public CustomerDTO findByPrimaryKey(int id, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from customer_master where custid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustid(rs.getInt("custid"));
				dto.setCustName(rs.getString("custname"));
				dto.setCustAddress(rs.getString("custaddress"));
				dto.setCustCity(rs.getString("custcity"));
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
	public Collection<CustomerDTO> findByCustomerAddress(String custaddress, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from customer_master where custaddress=?");
			List<CustomerDTO> customerList = new ArrayList<>();
			ps.setString(1, custaddress);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustid(rs.getInt("custid"));
				dto.setCustName(rs.getString("custname"));
				dto.setCustAddress(rs.getString("custaddress"));
				dto.setCustCity(rs.getString("custcity"));
				customerList.add(dto);
			}

			JDBCUtility.closeConnection(null, null);

			return customerList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<CustomerDTO> findAll(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from customer_master");
			List<CustomerDTO> userInfoList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				CustomerDTO dto = CustomerDTO.getInstance();
				dto.setCustid(rs.getInt("custid"));
				dto.setCustName(rs.getString("custname"));
				dto.setCustAddress(rs.getString("custaddress"));
				dto.setCustCity(rs.getString("custcity"));
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
	public int updateCustomerDTO(CustomerDTO customer, Connection con) {
		int status = 0;
		try {
			PreparedStatement ps = con.prepareStatement(
					"update customer_master set custname=? custaddress=? custcity=? where custid=?");

			if (customer != null) {
				ps.setString(1, customer.getCustName());
				ps.setString(2, customer.getCustAddress());
				ps.setString(3, customer.getCustCity());
				ps.setInt(4, customer.getCustid());

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
	public int deleteCustomerDTO(int id, Connection con) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from customer_master where custid=?");
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
	public int save(CustomerDTO inv, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
}

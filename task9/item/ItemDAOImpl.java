package task9.item;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import task9.JDBCUtility;

public class ItemDAOImpl extends ItemDAO implements Cloneable {
	private ItemDAOImpl() {
		System.out.println("trancation master dao object created....");
	}

	public static ItemDAOImpl getMultiTon() {
		return new ItemDAOImpl();
	}

	private static ItemDAOImpl dao;

	synchronized public static ItemDAOImpl getSingleTon() {
		if (dao == null) {
			dao = new ItemDAOImpl();
			return dao;
		} else {
			return dao;
		}
	}

	synchronized public static ItemDAOImpl getPrototype() {
		if (dao == null) {
			dao = new ItemDAOImpl();
			return dao;
		} else {
			return dao.getClone();
		}
	}

	synchronized public ItemDAOImpl getClone() {
		try {
			return (ItemDAOImpl) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ItemDTO findByPrimaryKey(int id, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from item where itemid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				ItemDTO dto = ItemDTO.getInstance();
				dto.setItemid(rs.getInt("itemid"));
				dto.setItemName(rs.getString("itemname"));
				dto.setItemPrice(rs.getInt("itemprice"));
				dto.setUnit(rs.getInt("unit"));
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
	public Collection<ItemDTO> findByItemName(String itemname, Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from item where itemname=?");
			List<ItemDTO> itemList = new ArrayList<>();
			ps.setString(1, itemname);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ItemDTO dto = ItemDTO.getInstance();
				dto.setItemid(rs.getInt("itemid"));
				dto.setItemName(rs.getString("itemname"));
				dto.setItemPrice(rs.getInt("itemprice"));
				dto.setUnit(rs.getInt("unit"));
				itemList.add(dto);
			}

			JDBCUtility.closeConnection(null, null);

			return itemList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public Collection<ItemDTO> findAll(Connection con) {
		try {
			PreparedStatement ps = con.prepareStatement("select * from item");
			List<ItemDTO> itemList = new ArrayList<>();
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ItemDTO dto = ItemDTO.getInstance();
				dto.setItemid(rs.getInt("itemid"));
				dto.setItemName(rs.getString("itemname"));
				dto.setItemPrice(rs.getInt("itemprice"));
				dto.setUnit(rs.getInt("unit"));
				itemList.add(dto);

			}

			JDBCUtility.closeConnection(null, null);

			return itemList;

		} catch (Exception e) {
			e.printStackTrace();
			JDBCUtility.closeConnection(e, null);
			return null;
		}
	}

	@Override
	public int updateItemDTO(ItemDTO transaction, Connection con) {
		int status = 0;
		try {
			PreparedStatement ps = con
					.prepareStatement("update item set itemname=? itemprice=? unit=? where itemid=?");

			if (transaction != null) {
				ps.setString(1, transaction.getItemName());
				ps.setInt(2, transaction.getItemPrice());
				ps.setInt(3, transaction.getUnit());
				ps.setInt(4, transaction.getItemid());

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
	public int deleteItemDTO(int id, Connection con) {

		try {
			PreparedStatement ps = con.prepareStatement("delete from item where itemid=?");
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
	public int save(ItemDTO inv, Connection con) {
		// TODO Auto-generated method stub
		return 0;
	}
}


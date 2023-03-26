package task9.item;

import java.sql.Connection;
import java.util.Collection;


public abstract class ItemDAO {
	public abstract ItemDTO findByPrimaryKey(int id,Connection con);
	public abstract Collection<ItemDTO> findByItemName(String itemname,Connection con);
	public abstract Collection<ItemDTO> findAll(Connection con);
	public abstract int updateItemDTO(ItemDTO inv,Connection con);
	public abstract int deleteItemDTO(int id,Connection con);
	public abstract int save(ItemDTO inv,Connection con);
}

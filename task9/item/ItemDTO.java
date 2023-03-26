package task9.item;

import java.io.Serializable;
import java.util.Objects;

public class ItemDTO implements Serializable, Cloneable, Comparable<ItemDTO> {
	private int itemid;
	private String itemname;
	private int itemprice;
	private int unit;

	@Override
	public int compareTo(ItemDTO o) {
		return this.itemid - o.itemid;
	}

	private static ItemDTO item_dto;

	synchronized public static ItemDTO getInstance() {
		if (item_dto == null) {
			item_dto = new ItemDTO();
			return item_dto;
		} else {
			return item_dto.createClone();
		}
	}

	synchronized public ItemDTO createClone() {
		try {
			return (ItemDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "ItemDTO [itemid=" + itemid + ", itemname=" + itemname + ", itemitemprice=" + itemprice + ", unit="
				+ unit + "]";
	}

	private ItemDTO() {
		System.out.println("Item master dto object created...");
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemName() {
		return itemname;
	}

	public void setItemName(String itemname) {
		this.itemname = itemname;
	}

	public int getItemPrice() {
		return itemprice;
	}

	public void setItemPrice(int itemprice) {
		this.itemprice = itemprice;
	}

	public int getUnit() {
		return unit;
	}

	public void setUnit(int unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(itemid, itemname, itemprice,unit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemDTO other = (ItemDTO) obj;
		return itemid == other.itemid && unit == other.unit && itemname.equals(other.itemname)
				&& itemprice == other.itemprice;
	}

}

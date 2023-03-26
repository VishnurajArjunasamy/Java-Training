package task9.transaction;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDTO implements Serializable, Cloneable, Comparable<TransactionDTO> {
	private int invid;
	private int itemid;
	private int quantity;
	private int price;

	@Override
	public int compareTo(TransactionDTO o) {
		return this.invid - o.invid;
	}

	private static TransactionDTO transaction_dto;

	synchronized public static TransactionDTO getInstance() {
		if (transaction_dto == null) {
			transaction_dto = new TransactionDTO();
			return transaction_dto;
		} else {
			return transaction_dto.createClone();
		}
	}

	synchronized public TransactionDTO createClone() {
		try {
			return (TransactionDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "TransactionDTO [invid=" + invid + ", itemid=" + itemid + ", quantity=" + quantity + ", price=" + price
				+ "]";
	}

	private TransactionDTO() {
		System.out.println("tarnsaction master dto object created...");
	}

	public int getInvid() {
		return invid;
	}

	public void setInvid(int invid) {
		this.invid = invid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(invid, itemid, quantity, price);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionDTO other = (TransactionDTO) obj;
		return invid == other.invid && itemid == other.itemid && quantity == other.quantity && price == other.price;
	}

}

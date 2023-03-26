package task9.invoice;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class InvoiceMasterDTO implements Serializable,Cloneable,Comparable<InvoiceMasterDTO>{
	private int invid;
	private int custid;
	private Date invdate;
	private int amount;
	private int discount;
	
	@Override
	public int compareTo(InvoiceMasterDTO o) {
		return	this.invid-o.invid;
	}
	private static InvoiceMasterDTO invm_dto;
	synchronized public static InvoiceMasterDTO getInstance() {
		if(invm_dto==null) {
			invm_dto=new InvoiceMasterDTO();
			return invm_dto;
		}
		else {
			return invm_dto.createClone();
		}
	}
	synchronized public InvoiceMasterDTO createClone() {
		try {
			return (InvoiceMasterDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public String toString() {
		return "InvoiceMasterDTO [invid=" + invid + ", custid=" + custid + ", invdate=" + invdate + ", amount=" + amount
				+ ", discount=" + discount + "]";
	}
	private InvoiceMasterDTO() {
		System.out.println("invoice master dto object created...");
	}
	public int getInvid() {
		return invid;
	}
	public void setInvid(int invid) {
		this.invid = invid;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public Date getInvdate() {
		return invdate;
	}
	public void setInvdate(Date invdate) {
		this.invdate = invdate;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	@Override
	public int hashCode() {
		return Objects.hash(amount, custid, discount, invdate, invid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InvoiceMasterDTO other = (InvoiceMasterDTO) obj;
		return amount == other.amount && custid == other.custid && discount == other.discount
				&& Objects.equals(invdate, other.invdate) && invid == other.invid;
	}
	
	
}






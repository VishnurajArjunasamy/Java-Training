package task9.cutomer;

import java.io.Serializable;
import java.util.Objects;

public class CustomerDTO implements Serializable, Cloneable, Comparable<CustomerDTO> {
	private int custid;
	private String custname;
	private String custaddress;
	private String custcity;

	@Override
	public int compareTo(CustomerDTO o) {
		return this.custid - o.custid;
	}

	private static CustomerDTO customer_dto;

	synchronized public static CustomerDTO getInstance() {
		if (customer_dto == null) {
			customer_dto = new CustomerDTO();
			return customer_dto;
		} else {
			return customer_dto.createClone();
		}
	}

	synchronized public CustomerDTO createClone() {
		try {
			return (CustomerDTO) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String toString() {
		return "CustomerDTO [custid=" + custid + ", custname=" + custname + ", custaddress=" + custaddress
				+ ", custcity=" + custcity + "]";
	}

	private CustomerDTO() {
		System.out.println("customer master dto object created...");
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public String getCustName() {
		return custname;
	}

	public void setCustName(String custname) {
		this.custname = custname;
	}

	public String getCustAddress() {
		return custaddress;
	}

	public void setCustAddress(String custaddress) {
		this.custaddress = custaddress;
	}

	public String getCustCity() {
		return custcity;
	}

	public void setCustCity(String custcity) {
		this.custcity = custcity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(custaddress, custid, custcity, custname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerDTO other = (CustomerDTO) obj;
		return custid == other.custid && custname.equals(other.custname) && custaddress.equals(other.custaddress)
				&& custcity.equals(other.custcity);
	}

}

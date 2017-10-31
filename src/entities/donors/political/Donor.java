package entities.donors.political;

public class Donor {
	private String id;
	private String zipCode;
	private String transation_DT;
	private int transation_AMT;
	private String other_ID;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getTransation_DT() {
		return transation_DT;
	}
	
	public void setTransation_DT(String transation_DT) {
		this.transation_DT = transation_DT;
	}
	
	public int getTransation_AMT() {
		return transation_AMT;
	}
	public void setTransation_AMT(int transation_AMT) {
		this.transation_AMT = transation_AMT;
	}
	
	public String getOther_ID() {
		return other_ID;
	}
	
	public void setOther_ID(String other_ID) {
		this.other_ID = other_ID;
	}
	
//	public String toString() {
//		return "id:" + this.id + "\nzip:" + this.zipCode + "\ndatetime:" + this.transation_DT + "\namount:" + this.transation_AMT
//				+ "\nother id:" + this.other_ID + "\n";
//	}
	
}

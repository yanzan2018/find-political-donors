package entities.donors.political;

public class DonorEntry extends Donor{
	private int totalAmt;
	private int transationNbr;
	private int median;
	
	public int getTotalAmt() {
		return totalAmt;
	}
	
	public void setTotalAmt(int totalAmt) {
		this.totalAmt = totalAmt;
	}
	
	public int getTransationNbr() {
		return transationNbr;
	}
	
	public void setTransationNbr(int transationNbr) {
		this.transationNbr = transationNbr;
	}
	
	public int getMedian() {
		return median;
	}
	
	public void setMedian(int median) {
		this.median = median;
	}
}

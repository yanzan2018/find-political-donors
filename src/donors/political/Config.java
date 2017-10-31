package donors.political;


/**
 * Configuration of the indices for extracting the data
 */
public class Config {
	private int idIdx;
	private int zipCodeIdx;
	private int dateIdx;
	private int amountIdx;
	private int otherIdIdx;
	
	public Config(int idIdx, int zipCodeIdx, int dateIdx, int amountIdx, int otherIdIdx) {
		this.idIdx = idIdx;
		this.zipCodeIdx = zipCodeIdx;
		this.dateIdx = dateIdx;
		this.amountIdx = amountIdx;
		this.otherIdIdx = otherIdIdx;
	}

	public int getIdIdx() {
		return idIdx;
	}
	
	public int getZipCodeIdx() {
		return zipCodeIdx;
	}
	
	public int getDateIdx() {
		return dateIdx;
	}
		
	public int getAmountIdx() {
		return amountIdx;
	}
	
	public int getOtherIdIdx() {
		return otherIdIdx;
	}
	
	
}

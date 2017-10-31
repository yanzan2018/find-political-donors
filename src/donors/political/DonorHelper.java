package donors.political;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import entities.donors.political.Donor;

public class DonorHelper {
	
	/**
	 * Convert String to Donor object
	 */
	public static Donor readAsDonor(String s, Config config) {
		if(s == null || s.length() == 0 || config == null)
			return null;

		Donor donor = new Donor();
		
		try {
			//split the String s by '|'
			String[] ps = s.split("\\|");
			
			String id = ps[config.getIdIdx()];
			if(id == null || id.length() == 0)
				return null;			
			donor.setId(id);
			
			String amt = ps[config.getAmountIdx()];
			if(amt == null || amt.length() == 0)
				return null;
			try {
				donor.setTransation_AMT(Integer.parseInt(amt));
			} catch (Exception e) {
				e.printStackTrace();
			}			

			String otherId = ps[config.getOtherIdIdx()];
			if(otherId != null && otherId.length() != 0)
				return null;
			donor.setOther_ID(otherId);
						
			String zipCode = ps[config.getZipCodeIdx()];
			if(zipCode.length() >= 5) {
				donor.setZipCode(zipCode.substring(0, 5));
			}
			
			String dateStr = ps[config.getDateIdx()];
			if(dateStr != null && dateStr.length() == 8) {		
				try {
					DateFormat df = new SimpleDateFormat("MMddyyyy"); 
					Date date = df.parse(dateStr);
					donor.setTransation_DT(df.format(date));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}	
	
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		return donor;
	}
	

}

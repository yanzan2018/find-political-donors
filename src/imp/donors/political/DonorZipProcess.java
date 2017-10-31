package imp.donors.political;

import java.io.IOException;

import donors.political.MedianFinder;
import entities.donors.political.Donor;
import entities.donors.political.DonorEntry;
import interfaces.donors.political.DonorProcess;

public class DonorZipProcess extends DonorProcess{

	public DonorZipProcess(String outputFileName) throws IOException {
		super(outputFileName);
	}

	@Override
	
	public void recordDonor(Donor donor) {
		if(donor == null || donor.getZipCode() == null)
			return;
		
		//Combine the key with id and zipcode, e.g. C00629618,90017
		String key = donor.getId() + "," + donor.getZipCode();
		
		//Instantiate the DonorEntry by key if not exist in the map
		if(!this.entryMap.containsKey(key)) {
			DonorEntry entry = new DonorEntry();
			entry.setId(donor.getId());
			entry.setZipCode(donor.getZipCode());			
			
			this.entryMap.put(key, entry);
		}
		
		//Instantiate the MedianFinder by key if not exist in the map
		if(!this.medianFinderMap.containsKey(key)) {
			this.medianFinderMap.put(key, new MedianFinder());
		}
		
		MedianFinder finder = this.medianFinderMap.get(key);
		finder.addNumber(donor.getTransation_AMT());
				
		DonorEntry entry = this.entryMap.get(key);
		entry.setTotalAmt(entry.getTotalAmt() + donor.getTransation_AMT());
		entry.setTransationNbr(entry.getTransationNbr() + 1);		
		entry.setMedian((int) Math.round(finder.findMedian()));
		
		this.entryMap.put(key, entry);
		
		try {
			//Stream recording, write the DonorEntry to the file on every record
			StringBuilder sb = new StringBuilder();
			sb.append(entry.getId()).append('|');
			sb.append(entry.getZipCode()).append('|');
			sb.append(entry.getMedian()).append('|');
			sb.append(entry.getTransationNbr()).append('|');
			sb.append(entry.getTotalAmt());
			
			this.writer.write(sb.toString());
			this.writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void finishRecord() {
		try {
			this.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

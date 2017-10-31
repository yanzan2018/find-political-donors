package imp.donors.political;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import donors.political.MedianFinder;
import entities.donors.political.Donor;
import entities.donors.political.DonorEntry;
import interfaces.donors.political.DonorProcess;

public class DonorDateProcess extends DonorProcess{

	public DonorDateProcess(String outputFileName) throws IOException {
		super(outputFileName);
	}

	@Override
	public void recordDonor(Donor donor) {
		if(donor == null || donor.getTransation_DT() == null)
			return;
		
		//Combine the key with id and date, e.g. C00629618,01232017
		String key = donor.getId() + "," + donor.getTransation_DT();
		
		//Instantiate the DonorEntry by key if not exist in the map
		if(!this.entryMap.containsKey(key)) {
			DonorEntry entry = new DonorEntry();
			entry.setId(donor.getId());
			entry.setTransation_DT(donor.getTransation_DT());
			this.entryMap.put(key, entry);
		}
		
		//Instantiate the MedianFinder by key if not exist in the map
		if(!this.medianFinderMap.containsKey(key)) {
			this.medianFinderMap.put(key, new MedianFinder());
		}
		
		MedianFinder finder = this.medianFinderMap.get(key);
		finder.addNumber(donor.getTransation_AMT());
		
		DonorEntry entry = this.entryMap.get(key);
		entry.setTransationNbr(entry.getTransationNbr() + 1);
		entry.setTotalAmt(entry.getTotalAmt() + donor.getTransation_AMT());		
		entry.setMedian((int) Math.round(finder.findMedian()));
		
		//update the entry by the key
		this.entryMap.put(key, entry);
	}

	@Override
	public void finishRecord() {		
		//write all the data to file on record complete
		//sort recipient by alphabetical and then chronologically by date.
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String ps1[] = o1.split(",");
				String ps2[] = o2.split(",");
				
				if(!ps1[0].equals(ps2[0])) {
					return ps1[0].compareTo(ps2[0]);
				}else {
					DateFormat df = new SimpleDateFormat("MMddyyyy"); 
					try {
						Date dt1 = df.parse(ps1[1]);
						Date dt2 = df.parse(ps2[1]);
						
						return dt1.compareTo(dt2);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
				return 0;
			}
		};
		
		SortedSet<String> keys = new TreeSet<String>(comparator);
		keys.addAll(this.entryMap.keySet());
		
		for(String key : keys) {
        	try {
            	DonorEntry entry = this.entryMap.get(key);
            	StringBuilder sb = new StringBuilder();
            	sb.append(entry.getId()).append('|');
            	sb.append(entry.getTransation_DT()).append('|');
            	sb.append(entry.getMedian()).append('|');
            	sb.append(entry.getTransationNbr()).append('|');
            	sb.append(entry.getTotalAmt());
            	
				this.writer.write(sb.toString());
				this.writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }       

		try {
			this.writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

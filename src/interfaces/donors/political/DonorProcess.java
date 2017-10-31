package interfaces.donors.political;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import donors.political.MedianFinder;
import entities.donors.political.DonorEntry;

public abstract class DonorProcess implements IDonorProcess{
	//record the DonorEntry using HashMap
	protected HashMap<String, DonorEntry> entryMap;
	
	//storage the numbers to find the median
	protected HashMap<String, MedianFinder> medianFinderMap;
	
	//the writer to write text to file
	protected BufferedWriter writer;
	
	public DonorProcess(String outputFileName) throws IOException {		
		entryMap = new HashMap<>();
		medianFinderMap = new HashMap<>();
		writer = new BufferedWriter(new FileWriter(outputFileName));
	}
}

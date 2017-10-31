package donors.political;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import entities.donors.political.Donor;
import imp.donors.political.DonorDateProcess;
import imp.donors.political.DonorZipProcess;
import interfaces.donors.political.DonorProcess;

public class App {

	//arguments: ./input/itcont.txt ./output/medianvals_by_zip.txt ./output/medianvals_by_date.txt
	public static void main(String[] args) throws IOException, ParseException {

		final String dir = System.getProperty("user.dir");
		String inputFileName = dir + args[0];
		String fileNameByZip = dir + args[1];
		String fileNameByDate = dir + args[2];
		
//		String inputFileName = dir + "/input" +"/itcont.txt";
//        String fileNameByZip = dir + "/output" + "/medianvals_by_zip.txt";
//        String fileNameByDate = dir + "/output" + "/medianvals_by_date.txt";


//		String inputFileName = dir + "\\input" +"\\itcont.txt";
//        String fileNameByZip = dir + "\\output" + "\\medianvals_by_zip.txt";
//        String fileNameByDate = dir+ "\\output" + "\\medianvals_by_date.txt";
        
		
		App app = new App();
		app.start(inputFileName, fileNameByZip, fileNameByDate);		
	}
		
	private void start(String inputFileName, String zipFileName, String dateFileName) throws IOException{
	
        Config cfg = new Config(0,10,13,14,15);
		
        DonorProcess zipDP = new DonorZipProcess(zipFileName);
        DonorProcess dateDP = new DonorDateProcess(dateFileName);

        //Read the input text file
        BufferedReader br = new BufferedReader(new FileReader(inputFileName));        
        String line;
        while((line = br.readLine()) != null) {
        	Donor donor = DonorHelper.readAsDonor(line, cfg);
        	//System.out.println(donor.toString());
        	
        	//record donor
        	zipDP.recordDonor(donor);
        	dateDP.recordDonor(donor);
		}
		br.close();
        
        zipDP.finishRecord();
        dateDP.finishRecord();
	}	
}

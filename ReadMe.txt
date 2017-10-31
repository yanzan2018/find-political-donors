1. Approach
	a. Read the input text file line by line.
	b. Convert every line to Donor object.
	c. Record the donor entry by Zip Code and by Date
	d. Write data to output files.
		
2. Implementation
		
	a. To convert string to object, here I am using a Config class which is able to use the index configuration of the input text.
	b. For the process of the donor, I used the HashMap to storage the entry, where the keys are made by "id,zipcode" and "id,date". Doing like this can easily update the data when a new line is coming. The DonorProcess is scalable, for more details, please see the interface IDonorProcess and the abstract class DonorProcess.
	c. To calculate the median, I am using the MaxHeap and MinHeap to achieve that. Inside the DonorProcess, there is another HashMap to record the amount and find the median. For more details, please see the MedianFinder class.
	d. The records by zip code is a record stream. It will write the new coming entry to the output text file. But the records by date is different. It has to read all the input data first, and then output. And it should also be sorted alphabetical by recipient and then chronologically by date. To implement this, I implement a new Comparator to compare the recipient and date.
		
	
3. Run Instruction
Please run the run.sh and run_tests.sh.
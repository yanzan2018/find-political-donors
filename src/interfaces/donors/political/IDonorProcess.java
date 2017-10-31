package interfaces.donors.political;

import entities.donors.political.Donor;

public interface IDonorProcess {
	void recordDonor(Donor donor);
	void finishRecord();
}

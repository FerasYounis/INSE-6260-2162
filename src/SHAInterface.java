import java.util.List;

import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Patient;

public interface SHAInterface {

	public void patientsRegisterting(String firstName, String lastName, String email, String password,
			Gender patientGender, Location location, String specailCase);

	public void nursesRegisterting(String firstName, String lastName, String email, String password, Gender nurseGender,
			Location location, List<TypeOfRequest> typeOfRequest);

	public boolean patientLogLin(String userName, String password);
	
	public boolean nurseLogLin(String userName, String password);
	
	public boolean AgencyLogLin(String userName, String password);

	public String RequestApp(Patient patient, Gender nurseG, TimeSlot app, String severity, Language language,
			TypeOfRequest typeCareService, String comment);

	public void matchApp();

	public void cancelApp( String requestID);

	public void availabilityUpdate( String schedule);

	public String viewStatus(String loggedin, String requestID);
}

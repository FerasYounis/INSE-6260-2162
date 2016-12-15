import java.util.List;

import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Login;
import profiles.Nurse;
import profiles.Patient;

public interface SHAInterface {

	public Patient patientsRegisterting(String firstName, String lastName, String email, String password,
			Gender patientGender, Location location, String specailCase);

	public Nurse nursesRegisterting(String firstName, String lastName, String email, String password, Gender nurseGender,
			Location location, List<TypeOfRequest> typeOfRequest, Language language);

	public Login patientLogLin(String userName, String password);

	public Login nurseLogLin(String userName, String password);

	public boolean AgencyLogLin(String userName, String password);

	public String RequestApp(Patient patient, Gender nurseG, TimeSlot app, String severity, Language language,
			TypeOfRequest typeCareService, String comment);

	public void matchApp();

	public void cancelApp(String id, String requestID);

	public void availabilityUpdate(int slot, String status);

	public String viewStatus(String loggedin, String requestID);
}

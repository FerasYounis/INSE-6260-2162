import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Nurse;
import profiles.Patient;

public class SHAImplementation implements SHAInterface {

	private List<Patient> patientList = new ArrayList<>();
	private List<Nurse> nurseList = new ArrayList<>();

	@Override
	public void patientsRegisterting(String firstName, String lastName, String email, String password,
			Gender patientGender, Location location, String specailCase) {

		Patient patient = new Patient(firstName, lastName, email, password, patientGender, location, specailCase);
		patientList.add(patient);
	}

	@Override
	public void nursesRegisterting(String firstName, String lastName, String email, String password, Gender nurseGender,
			Location location, List<TypeOfRequest> typeOfRequest) {
		Nurse nurse = new Nurse(firstName, lastName, email, password, nurseGender, location, typeOfRequest);
		nurseList.add(nurse);

	}

	@Override
	public boolean patientLogLin(String userName, String password) {

		return false;
	}

	@Override
	public String RequestApp(Patient patient, Gender nurseG, TimeSlot app, String severity, Language language,
			TypeOfRequest typeCareService, String comment) {

		return null;
	}

	@Override
	public void matchApp() {
		// TODO Auto-generated method stub
		Nurse[] sortedNurses = nurseList.toArray(new Nurse[0]);
		Arrays.sort(sortedNurses);

	}

	@Override
	public void cancelApp(String loggedin, String requestID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void availabilityUpdate(String loggedin, String schedule) {
		// TODO Auto-generated method stub

	}

	@Override
	public String viewStatus(String loggedin, String requestID) {
		// TODO Auto-generated method stub
		return null;
	}

}

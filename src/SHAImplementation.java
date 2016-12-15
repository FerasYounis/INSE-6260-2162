import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Enums.AvailableTimeStatusNures;
import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.RequestStatus;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Nurse;
import profiles.Patient;
import profiles.Request;

public class SHAImplementation implements SHAInterface {

	private List<Patient> patientList = new ArrayList<>();
	private List<Request> requestList = new ArrayList<>();
	private List<Nurse> nurseList = new ArrayList<>();
	private String adminName = "admin";
	private String adminPassword = "admin123";

	@Override
	public void patientsRegisterting(String firstName, String lastName, String email, String password,
			Gender patientGender, Location location, String specailCase) {

		Patient patient = new Patient(firstName, lastName, email, password, patientGender, location, specailCase);
		patientList.add(patient);
	}

	@Override
	public void nursesRegisterting(String firstName, String lastName, String email, String password, Gender nurseGender,
			Location location, List<TypeOfRequest> typeOfRequest, Language language) {
		Nurse nurse = new Nurse(firstName, lastName, email, password, nurseGender, location, typeOfRequest, language);
		nurseList.add(nurse);

	}

	@Override
	public boolean patientLogLin(String userName, String password) {

		for (Patient patient : patientList) {

			if (patient.getFirstName().equals(userName) && patient.getPassword().equals(password)) {

				System.out.println("Credentials Accepted.");
				return true;

			} else {
				System.out.println("Wrong! Username or/and Password\n");
				System.out.println("Please try again!");

			}

		}
		return false;
	}

	@Override
	public boolean nurseLogLin(String userName, String password) {

		for (Nurse nurse : nurseList) {

			if (nurse.getFirstName().equals(userName) && nurse.getPassword().equals(password)) {

				System.out.println("Credentials Accepted.");
				return true;

			} else {
				System.out.println("Wrong! Username or/and Password\n");
				System.out.println("Please try again!");

			}

		}
		return false;

	}

	@Override
	public boolean AgencyLogLin(String userName, String password) {

		if (adminName.equals(userName) && adminPassword.equals(password)) {
			System.out.println("Credentials Accepted.");
			return true;
		} else {
			System.out.println("Wrong! Username or/and Password\n");
			System.out.println("Please try again!");
		}
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
		for (Request request : requestList) {
			for (Nurse nurse : sortedNurses) {
				System.out.println("checking patient :" + request.getPatient() + "with nurse:" + nurse);
				if (nurse.getLocation() == request.getPatient().getLocation()
						&& nurse.getLanguage() == request.getLanguage()
						&& nurse.getTypeOfRequest().contains(request.getTypeCareService())
						&& nurse.getNurseGender() == request.getNurseG()
						&& nurse.getSchedule()[request.getApp().ordinal()]
								.getStatus() == AvailableTimeStatusNures.AVAILABLE) {
					nurse.getSchedule()[request.getApp().ordinal()].setStatus(AvailableTimeStatusNures.BOOKED);
					nurse.getSchedule()[request.getApp().ordinal()].setRequest(request);
					request.setAssignedNurse(nurse);
					request.setStatus(RequestStatus.ASSIGNED);
					break;
				}
			}
			if (request.getStatus() == RequestStatus.NEW) {
				request.setStatus(RequestStatus.NO_NURSE_AVAILABLE);
			}

		}

	}

	@Override
	public void cancelApp(String id, String requestID) {
		// TODO Auto-generated method stub

	}

	@Override
	public void availabilityUpdate(int slot, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public String viewStatus(String loggedin, String requestID) {
		// TODO Auto-generated method stub
		return null;
	}

}

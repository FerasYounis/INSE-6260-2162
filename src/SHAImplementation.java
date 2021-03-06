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
import profiles.Login;
import profiles.Nurse;
import profiles.NurseTimeSlot;
import profiles.Patient;
import profiles.Request;

public class SHAImplementation implements SHAInterface {

	private List<Patient> patientList = new ArrayList<>();
	private List<Request> requestList = new ArrayList<>();
	private List<Nurse> nurseList = new ArrayList<>();
	private String adminName = "admin";
	private String adminPassword = "admin123";

	@Override
	public Patient patientsRegisterting(String firstName, String lastName, String email, String password,
			Gender patientGender, Location location, String specailCase) {

		Patient patient = new Patient(firstName, lastName, email, password, patientGender, location, specailCase);
		patientList.add(patient);
		System.out.println("New Patient been: " + patient);
		return patient;
	}

	@Override
	public Nurse nursesRegisterting(String firstName, String lastName, String email, String password,
			Gender nurseGender, Location location, List<TypeOfRequest> typeOfRequest, Language language) {
		Nurse nurse = new Nurse(firstName, lastName, email, password, nurseGender, location, typeOfRequest, language);
		nurseList.add(nurse);
		return nurse;

	}

	@Override
	public Login patientLogLin(String userName, String password) {

		for (Patient patient : patientList) {

			if (patient.getFirstName().equals(userName) && patient.getPassword().equals(password)) {

				System.out.println("Credentials Accepted.");
				Login patientLogin = new Login(true, patient);
				return patientLogin;

			} else {
				System.out.println("Wrong! Username or/and Password\n");
				System.out.println("Please try again!");

			}

		}
		return null;
	}

	@Override
	public Login nurseLogLin(String userName, String password) {

		for (Nurse nurse : nurseList) {

			if (nurse.getFirstName().equals(userName) && nurse.getPassword().equals(password)) {

				System.out.println("Credentials Accepted.");
				Login nurseLogin = new Login(true, nurse);
				return nurseLogin;

			} else {
				System.out.println("Wrong! Username or/and Password\n");
				System.out.println("Please try again!");

			}

		}
		return null;

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
		Request request = new Request(patient, nurseG, app, severity, language, typeCareService, comment);
		requestList.add(request);

		return request.getRequestID();
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
	public void cancelApp(String requestID) {
		for (Request request : requestList) {
			if (requestID.equals(request.getRequestID())) {
				request.setStatus(RequestStatus.CANCELED);
				for (NurseTimeSlot slot : request.getAssignedNurse().getSchedule()) {
					if (slot.getRequest() == request) {
						slot.setStatus(AvailableTimeStatusNures.AVAILABLE);
						System.out.println("The request " + request.getRequestID() 
						+"has been CANCELED\nRequest Status: " + request.getStatus());
					}
				}
			}
		}

	}

	@Override
	public void availabilityUpdate(Nurse nurse, int slot, String status) {

		nurse.getSchedule()[slot].setStatus(AvailableTimeStatusNures.valueOf(status));

	}

	@Override
	public void viewStatus(String requestID) {
		for (Request request : requestList) {
			if (requestID.equals(request.getRequestID())) {
				System.out.println(request);
			}
		}
	}

	public void viewStatuses() {
		System.out.println("viewStatuses called");
		/*
		 * for (Request request : requestList) { System.out.println(
		 * "viewStatuses called request"); System.out.println(request);
		 * 
		 * }
		 */

		for (Nurse nurse : nurseList) {
			System.out.println(nurse);
		}

		for (Request request : requestList) {
			System.out.println("viewStatuses called request");
			System.out.println(request);

		}

	}
}

package profiles;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import Enums.Gender;
import Enums.Location;

public class Patient {
	/**
	 * 
	 */

	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Gender patientGender;
	private String specailCase;
	private Location location;
	private static String patientID;
	private List<Request> requests;
	private static int counter = 0;

	public Patient(String firstName, String lastName, String email, String password, Gender patientGender,
			Location location, String specailCase) {
		
		counter = counter +1;
		patientID = "P000E0" + String.valueOf(counter);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.patientGender = patientGender;
		this.location = location;
		this.specailCase = specailCase;
		requests = new ArrayList<>();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPatientID() {
		return patientID;
	}

	public String getPassword() {
		return password;
	}

	public Location getLocation() {
		return location;
	}

	public Gender getPatientGender() {
		return patientGender;
	}

	public String getEmail() {
		return email;
	}

	public String getSpecailCase() {
		return specailCase;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void addRequest(Request request) {
		requests.add(request);
	}

	public String toString() {
		return "Patient {" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", patientID='"
				+ patientID + '\'' + ", location='" + location + '\'' + ", patientGender='" + patientGender + '\''
				+ ", specailCase='" + specailCase + '\'' + ", email='" + email + '\'' + ", password= ***********'"
				+ '\'' + '}';

	}
}
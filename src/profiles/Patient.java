package profiles;

import java.util.UUID;

import Enums.Gender;
import Enums.Location;

public class Patient {
	/**
	 * 
	 */

	private static final long serialVersionUID = -4575375139164741007L;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Gender patientGender;
	private String specailCase;
	private Location location;
	private static String patientID;

	public Patient(String firstName, String lastName, String email, String password, Gender patientGender,
			Location location, String specailCase) {

		patientID = UUID.randomUUID().toString();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.patientGender = patientGender;
		this.location = location;
		this.specailCase = specailCase;
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

	public String toString() {
		return "Passenger{" + "firstName='" + firstName + '\'' + ", lastName='" + lastName + '\'' + ", patientID='"
				+ patientID + '\'' + ", location='" + location + '\'' + ", patientGender='" + patientGender + '\''
				+ ", specailCase='" + specailCase + '\'' + ", email='" + email + '\'' + ", password= ***********'"
				+ '\'' + '}';

	}
}
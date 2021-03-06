package profiles;

import java.util.List;

import Enums.AvailableTimeStatusNures;
import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TypeOfRequest;

public class Nurse implements Comparable<Nurse> {
	/*
	 * 
	 */
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Gender nurseGender;
	private List<TypeOfRequest> typeOfRequest;
	private Location location;
	private static String nurseID;
	private static int counter = 0;
	private NurseTimeSlot[] schedule;
	private Language language;

	public Nurse(String firstName, String lastName, String email, String password, Gender nurseGender,
			Location location, List<TypeOfRequest> typeOfRequest, Language language) {

		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.nurseGender = nurseGender;
		this.location = location;
		this.typeOfRequest = typeOfRequest;
		counter = counter + 1;
		nurseID = "NR00T5X" + String.valueOf(counter);
		schedule = new NurseTimeSlot[] { new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING) };
		this.language = language;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getNurseID() {
		return nurseID;
	}

	public String getPassword() {
		return password;
	}

	public Location getLocation() {
		return location;
	}

	public Gender getNurseGender() {
		return nurseGender;
	}

	public String getEmail() {
		return email;
	}

	public List<TypeOfRequest> getTypeOfRequest() {
		return typeOfRequest;
	}

	public void setSchedule(NurseTimeSlot[] schedule) {
		this.schedule = schedule;
	}

	public NurseTimeSlot[] getSchedule() {
		return schedule;
	}

	public int getBookedSlots() {
		int count = 0;
		for (NurseTimeSlot slot : schedule) {
			if (slot.getStatus() == AvailableTimeStatusNures.BOOKED) {
				count++;
			}
		}
		return count;
	}

	public int getNotWorkingSlots() {
		int count = 5;
		for (NurseTimeSlot slot : schedule) {
			if (slot.getStatus() == AvailableTimeStatusNures.NOTWORKING) {
				count--;
			}
		}
		return count;
	}

	@Override
	public String toString() {
		return "Nurse [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password="
				+ password + ", nurseGender=" + nurseGender + ", typeOfRequest=" + typeOfRequest + ", location="
				+ location + ", language=" + language + "]";
	}

	public int compareTo(Nurse compareNurse) {

		if (this.getNotWorkingSlots() == compareNurse.getNotWorkingSlots()) {
			return this.getBookedSlots() > compareNurse.getBookedSlots() ? 1 : -1;
		}
		if (this.getNotWorkingSlots() > compareNurse.getNotWorkingSlots()) {
			return 1;
		} else {
			return -1;
		}

	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

}
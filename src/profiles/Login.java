package profiles;

public class Login {

	boolean loginStatus = false;
	Patient patient;
	Nurse nurse;

	public Login(boolean loginStatus, Patient patient) {
		this.loginStatus = loginStatus;
		this.patient = patient;
	}

	public Login(boolean loginStatus, Nurse nurs) {
		this.loginStatus = loginStatus;
		this.nurse = nurs;
	}

	public boolean isLoggedin() {
		return loginStatus;
	}

	public Patient getPatient() {
		return patient;
	}

	public Nurse getNurse() {
		return nurse;
	}

}

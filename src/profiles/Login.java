package profiles;

public class Login {
	
	boolean loginStatus = false;
	Patient patient;
	Nurse nurse;
	
	public Login(boolean loginStatus, Patient patient){
		this.loginStatus = loginStatus;
		this.patient = patient;
	}
	
	public Login(boolean loginStatus, Nurse nurs){
		this.loginStatus = loginStatus;
		this.nurse = nurs;
	}

}

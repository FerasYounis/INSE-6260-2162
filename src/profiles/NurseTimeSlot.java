package profiles;

import Enums.AvailableTimeStatusNures;

public class NurseTimeSlot {
	private AvailableTimeStatusNures status;
	private Patient patient;

	public NurseTimeSlot(AvailableTimeStatusNures status,Patient patient){
		this.status = status;
		this.patient = patient;
	}
	public NurseTimeSlot(AvailableTimeStatusNures status){
		this(status,null);
	}
	public AvailableTimeStatusNures getStatus() {
		return status;
	}
	public void setStatus(AvailableTimeStatusNures status) {
		this.status = status;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}

}

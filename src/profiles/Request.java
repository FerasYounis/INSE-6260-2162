package profiles;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Enums.Gender;
import Enums.Language;
import Enums.RequestStatus;
import Enums.TimeSlot;
import Enums.TypeOfRequest;

public class Request {

	private static final Logger LOGGER = Logger.getLogger(Request.class.getName());
	private Patient patient;
	private Nurse assignedNurse;
	private Gender nurseG;
	private TimeSlot app;
	private String severity;
	private Language language;
	private TypeOfRequest typeCareService;
	private String comment;
	private static String requestID;
	private static int counter = 0;
	private RequestStatus status;

	public Request(Patient patient, Gender nurseG, TimeSlot app, String severity, Language language,
			TypeOfRequest typeCareService, String comment) {

		this.patient = patient;
		this.nurseG = nurseG;
		this.app = app;
		this.severity = severity;
		this.language = language;
		this.typeCareService = typeCareService;
		this.comment = comment;
		counter = counter + 1;
		requestID = "RID9AS00" + String.valueOf(counter);
		status = RequestStatus.NEW;

		try {
			FileHandler fileHandler = new FileHandler(requestID + "_RequestID_logger.log", false);
			fileHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(fileHandler);
			ConsoleHandler consoleHandler = new ConsoleHandler();
			consoleHandler.setFormatter(new SimpleFormatter());
			LOGGER.addHandler(consoleHandler);
			LOGGER.setLevel(Level.ALL);

			System.err.println(
					"Request ID: " + requestID + " is issued!\n" + "Patient Full Name: " + patient.getFirstName() + " "
							+ patient.getLastName() + "\n is waiting approval from the Agency\n");

		} catch (SecurityException | IOException e) {
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Gender getNurseG() {
		return nurseG;
	}

	public void setNurseG(Gender nurseG) {
		this.nurseG = nurseG;
	}

	public TimeSlot getApp() {
		return app;
	}

	public void setApp(TimeSlot app) {
		this.app = app;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public TypeOfRequest getTypeCareService() {
		return typeCareService;
	}

	public void setTypeCareService(TypeOfRequest typeCareService) {
		this.typeCareService = typeCareService;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public static void setRequestID(String requestID) {
		Request.requestID = requestID;
	}
	
	public static String getRequestID(){
		return requestID;
	}

	public Nurse getAssignedNurse() {
		return assignedNurse;
	}

	public void setAssignedNurse(Nurse assignedNurse) {
		this.assignedNurse = assignedNurse;
	}

	public RequestStatus getStatus() {
		return status;
	}

	public void setStatus(RequestStatus status) {
		this.status = status;
	}

}

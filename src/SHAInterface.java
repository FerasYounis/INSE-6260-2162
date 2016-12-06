public interface SHAInterface {
	
	
	
	public void patientsRegisterting(String firstName, String lastName, String email, String password, String patientGender, String location, String specailCase);
	
	public boolean patientLogLin(String userName, String password);
	
	public String RequestApp(String loggedin, String nyrseG, String time, String severity, String language, String typeCareService, String comment);
	
	public void matchApp();
	
	public void cancelApp(String loggedin, String requestID);
	
	public void availabilityUpdate(String loggedin, String schedule);
	
	public String viewStatus( String loggedin, String requestID);
}

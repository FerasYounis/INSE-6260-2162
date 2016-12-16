
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Enums.AvailableTimeStatusNures;
import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Login;
import profiles.Nurse;
import profiles.NurseTimeSlot;
import profiles.Patient;
import profiles.Request;

public class WebPortalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		boolean exit = false;
		SHAImplementation sha = new SHAImplementation();

		do {
			
			System.out.println("Welcome to Healthcare Agency\n" + "Please Login if you have a profile with the Agency"
					+ " or create one\n" + "1.Login enter 1" + "2.Registering enter 2" );
			Scanner sd = new Scanner(System.in);
			int num = sd.nextInt();
			switch (num) {
			case 1:
				boolean exitPatient = false;
				boolean exitNurse = false;
				boolean exitAgency = false;
				System.out.println("1.Patient");
				System.out.println("2.Nurse");
				System.out.println("3.Agency personal");
				System.out.println("Please choice one!");
				num = sd.nextInt();
				switch (num) {
				case 1:
					
					System.out.println("Please login");
					System.out.println("UserName: ");
					String userName = sd.next();
					System.out.println("Password: ");
					String password = sd.next();
					Login user = sha.patientLogLin(userName, password);
					if (user.isLoggedin()) {
						do {
							
							System.out.println("Please choose");
							System.out.println("1.Make a new request");
							System.out.println("2.View a request status");
							System.out.println("3.Cancel a request");
							System.out.println("4.Select 4 to exit Patient");
							int ans = sd.nextInt();
							switch (ans) {
							case 1:
								System.out.println("Please answer these questions");
								System.out.println("What is the gender of the nurse you prefer?");
								String genderstr = sd.next();
								Gender gender = Gender.valueOf(genderstr);
								System.out.println("Waht is the time you prefer?" + "From 9 To 11 = 0 "
										+ "From 11 To 1 = 1" + "From 1 To 3 = 2" + "From 3 To 5 = 3" + "From 5 To 7 = 4");
								int appint = sd.nextInt();

								TimeSlot app = TimeSlot.values()[appint];
								System.out.println("waht is the severity of your condition?");
								String severity = sd.next();
								System.out.println("Which language do you prefer?\n English or French");
								String languagestr = sd.next();
								Language language = Language.valueOf(languagestr);
								System.out.println("Waht service are you looking for? " + "BooldCare, " + "SeniorCare, "
										+ "SurgeryRecoveryCare, " + "NewbornCare, " + "VaccineCare");
								String typeOfRequestStr = sd.next();
								TypeOfRequest typeCareService = TypeOfRequest.valueOf(typeOfRequestStr);
								System.out.println("Please give any comment?");
								String comment = sd.next();
								String requestId = sha.RequestApp(user.getPatient(), gender, app, severity, language,
										typeCareService, comment);
								break;
							case 2:
								System.out.println("what is the ID of the request you want to check?");
								String requestID = sd.next();
								sha.viewStatus(requestID);
								break;
								
							case 3:
								System.out.println("What is the ID of the request you want to cancel?");
								String requestIDCancel = sd.next();
								sha.cancelApp(requestIDCancel);
								break;
							case 4:
								exitPatient = true;
							}
						}while (!exitPatient);
					}
					
							
						case 2:
							System.out.println("Please login");
							System.out.println("UserName: ");
							String userNameN = sd.next();
							System.out.println("Password: ");
							String passwordN = sd.next();
							Login userN = sha.nurseLogLin(userNameN, passwordN);
							if (userN.isLoggedin()) {
								
								do {
									System.out.println("Please choose");
									System.out.println("1.availability Update");
									System.out.println("2.View a request status");
									System.out.println("3.Cancel a request");
									System.out.println("4.View daily schedule");
									System.out.println("5.Select 4 to exit Nurse");
									int ans2 = sd.nextInt();
									switch (ans2){
									case 1:
										int timpeSlotChoice;
										List<NurseTimeSlot> nurseTimeSlot = new ArrayList<>();
										
										
										do {
											System.out.println("Pelease enter your time :\n" + "0.Done 1 for available and 2 for not working\n" + "9-11\n"
													+ "11-1\n" + "1-3\n" + "3-5\n" + "5-7\n");
											timpeSlotChoice = sd.nextInt();
											nurseTimeSlot.add(new NurseTimeSlot(AvailableTimeStatusNures.values()[timpeSlotChoice]));
											
										} while (timpeSlotChoice != 0);
									//	userN.getNurse().setSchedule(nurseTimeSlot);
										break;
										
									case 2:
										System.out.println("what is the ID of the request you want to check?");
										String requestID = sd.next();
										sha.viewStatus(requestID);
										break;
										
									case 3:
										System.out.println("What is the ID of the request you want to cancel?");
										String requestIDCancel = sd.next();
										sha.cancelApp(requestIDCancel);
										break;
										
									case 4:
										System.out.println(userN.getNurse().getSchedule());
										break;
										
									case 5:
										exitNurse = true;
										
										
										
								}
								}while(!exitNurse);
							}break;
						case 3:	
							System.out.println("Welcome Agency admin\n please inter OK to match all request");
							String ok = sd.next();
							sha.matchApp();
				}
						
			break;
							
									
								
							
								
									
				

			case 2:
				System.out.println("Who are you? \n1.Patient or 2.Nurse?");
				int WhoAreYou = sd.nextInt();
				if (WhoAreYou == 1) {
					System.out.println("Please enter First Name");
					String firstName = sd.next();
					System.out.println("Please enter Last Name");
					String lastName = sd.next();
					System.out.println("Pelease enter email and password");
					String email = sd.next();
					String password = sd.next();
					System.out.println("What is your Gender: MALE or FEMALE?");
					String patientGenderstr = sd.next();
					Gender patientGender = Gender.valueOf(patientGenderstr);
					System.out.println("Please enter your location" + "Montreal or Laval or South_shore");
					String locationstr = sd.next();
					Location location = Location.valueOf(locationstr);
					System.out.println(
							"Do you have a Specail Case \nex. genetic disorder " + "diseases or/and allergic?");
					String specailCase = sd.next();

					Patient patient = sha.patientsRegisterting(firstName, lastName, email, password, patientGender,
							location, specailCase);
					System.out.println(patient);
				} else if (WhoAreYou == 2) {
					System.out.println("Please enter First Name");
					String firstName = sd.next();
					System.out.println("Please enter Last Name");
					String lastName = sd.next();
					System.out.println("Pelease enter email and password");
					String email = sd.next();
					String password = sd.next();
					System.out.println("What is your Gender: MALE or FEMALE?");
					String nurseGenderstr = sd.next();
					Gender nurseGender = Gender.valueOf(nurseGenderstr);
					System.out.println("Please enter your location" + "Montreal or Laval or South_shore");
					String locationstr = sd.next();
					Location location = Location.valueOf(locationstr);
					System.out.println("What kind of Request do you serve?");
					System.out.println("Pelease enter language");
					String language = sd.next();
					String specailCase = sd.next();
					int typesOfRequestChoice = 1;
					List<TypeOfRequest> typesOfRequest = new ArrayList<>();
					do {
						System.out.println("Pelease enter type of service you do :\n" + "0-Done\n" + "1-BooldCar\n"
								+ "2-SeniorCare\n" + "3-SurgeryRecoveryCare\n" + "4-NewbornCare\n" + "5-VaccineCare\n");
						typesOfRequestChoice = sd.nextInt();
						typesOfRequest.add(TypeOfRequest.values()[typesOfRequestChoice - 1]);
					} while (typesOfRequestChoice != 0);

					Nurse nurse = sha.nursesRegisterting(firstName, lastName, email, password, nurseGender, location,
							typesOfRequest, Language.valueOf(language));

					System.out.println(nurse);
					break;
				}
				break;

			}
	}while (!exit);
}
	}

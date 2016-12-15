

import java.util.List;
import java.util.Scanner;

import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Login;
import profiles.Nurse;
import profiles.Patient;

public class WebPortalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		boolean exit = false;
		

		do {
			System.out
					.println("Welcome to Healthcare Agency\n" + 
							"Please Login if you have a profile with the Agency"
							+ " or create one\n" 
							+ "1.Login enter 1" 
							+ "2.Registering enter 2");
			Scanner sd = new Scanner(System.in);
			int num = sd.nextInt();
			switch (num) {
			case 1:
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
					Login user = patientLogLin( userName,  password);
					if (user.loginStatus.status){ //////hellllo///
						do{
							System.out.println("Please choose"
									+ "1.Make a new request"
									+ "2.View a request status"
									+ "3.Cancel a request");
							int ans = sd.nextInt();
							switch(ans){
							case 1:
								System.out.println("Please answer these questions");
								System.out.println("What is the gender of the nurse you prefer?");
								String genderstr = sd.next();
								Gender gender = Gender.valueOf(genderstr);
								System.out.println("Waht is the time you prefer?"
										+ "From 9 To 11 = 0 "
										+ "From11 To_1 = 1"
										+ "From1 To 3 = 2"
										+ "From 3 To 5 = 3"
										+ "From 5 To 7 = 4");
								int appint = sd.nextInt();
								TimeSlot app = TimeSlot.(appint); ///// hehehehe///
								
								
								
								String RequestApp(Patient patient, Gender nurseG, TimeSlot app, String severity, Language language,
										TypeOfRequest typeCareService, String comment);
							}
							
						}while(!exit);
					}
					
				}

			case 2:
				System.out.println("Who are you?"
						+ " 1.Patient or 2.Nurse?");
				int WhoAreYou = sd.nextInt();
				if (WhoAreYou == 1){
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
					System.out.println("Please enter your location"
							+ "Montreal or Laval or South_shore");
					String locationstr = sd.next();
					Location location = Location.valueOf(locationstr);
					System.out.println("Do you have a Specail Case \nex. genetic disorder "
							+ "diseases or/and allergic?");
					String specailCase = sd.next();
					
					Patient patient = patientsRegisterting( firstName,  lastName,  email,  password, patientGender,  location,  specailCase);
					System.out.println(patient);
				}else if (WhoAreYou == 2){
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
					System.out.println("Please enter your location"
							+ "Montreal or Laval or South_shore");
					String locationstr = sd.next();
					Location location = Location.valueOf(locationstr);
					System.out.println("What kind of Request do you serve?");
					System.out.println("Pelease enter language");
					String language = sd.next();
					String specailCase = sd.next();
					
					Nurse nurse =nursesRegisterting( firstName,  lastName,  email,  password,  nurseGender,
							 location,  typeOfRequest,  language);
					
					System.out.println(nurse);
					break;
				}break;

			}
		} while (!exit);
	}

}

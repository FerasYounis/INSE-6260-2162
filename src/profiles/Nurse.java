package profiles;

import java.util.UUID;

import Enums.Location;
import Enums.TypeOfRequest;

public class Nurse {
/*
 * 
 */
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String nurseGender;
	private TypeOfRequest typeOfRequest;
	private Location location;
	private static String nurseID;
	private static int counter = 0;


public Nurse(String firstName, String lastName, String email, String password, String nurseGender, Location location, 
		 TypeOfRequest typeOfRequest) {
	
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.password = password;
	this.nurseGender = nurseGender;
	this.location = location;
	this.typeOfRequest = typeOfRequest;
	counter = counter +1;
	nurseID = "NR00T5X"+ String.valueOf(counter);
}

public String getFirstName(){
	return firstName;
}

public String getLastName(){
	return lastName;
}

public String getNurseID(){
	return nurseID;
}

public String getPassword(){
	return password;
}

public Location getLocation(){
	return location;
}

public String NurseGender(){
	return nurseGender;
}

public String getEmail(){
	return email;
}

public TypeOfRequest getTypeOfRequest(){
	return typeOfRequest;
}

public String toString() {
    return "Passenger{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", NurseID='" + nurseID + '\'' +
            ", location='" + location + '\'' +
            ", nurseGender='" + nurseGender + '\'' +
            ", typeOfRequest='" + typeOfRequest + '\'' +
            ", email='" + email + '\'' +
            ", password= ***********'"  + '\'' +
            '}';





}
	
}
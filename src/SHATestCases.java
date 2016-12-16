import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import Enums.AvailableTimeStatusNures;
import Enums.Gender;
import Enums.Language;
import Enums.Location;
import Enums.TimeSlot;
import Enums.TypeOfRequest;
import profiles.Nurse;
import profiles.NurseTimeSlot;
import profiles.Patient;

public class SHATestCases {
	SHAImplementation sha = new SHAImplementation();

	@Before
	public void setUp() throws Exception {
		List<TypeOfRequest> nurseCareTypes1 = new ArrayList<TypeOfRequest>();
		nurseCareTypes1.add(TypeOfRequest.BooldCar);
		nurseCareTypes1.add(TypeOfRequest.SeniorCare);

		List<TypeOfRequest> nurseCareTypes2 = new ArrayList<TypeOfRequest>();
		nurseCareTypes1.add(TypeOfRequest.NewbornCare);
		nurseCareTypes1.add(TypeOfRequest.SeniorCare);

		List<TypeOfRequest> nurseCareTypes3 = new ArrayList<TypeOfRequest>();
		nurseCareTypes1.add(TypeOfRequest.BooldCar);
		nurseCareTypes1.add(TypeOfRequest.SurgeryRecoveryCare);

		NurseTimeSlot[] schedule1 = new NurseTimeSlot[] { new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE) };
		NurseTimeSlot[] schedule2 = new NurseTimeSlot[] { new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE) };
		NurseTimeSlot[] schedule3 = new NurseTimeSlot[] { new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.NOTWORKING),
				new NurseTimeSlot(AvailableTimeStatusNures.AVAILABLE) };

		Nurse nurse1 = sha.nursesRegisterting("nurse1", "nusrse1", "nurse1@email.com", "123", Gender.MALE,
				Location.Montreal, nurseCareTypes1, Language.English);
		nurse1.setSchedule(schedule1);
		Nurse nurse2 = sha.nursesRegisterting("nurse2", "nusrse2", "nurse2@email.com", "123", Gender.FEMALE,
				Location.Montreal, nurseCareTypes2, Language.English);
		nurse1.setSchedule(schedule2);
		Nurse nurse3 = sha.nursesRegisterting("nurse3", "nusrse3", "nurse3@email.com", "123", Gender.MALE,
				Location.Laval, nurseCareTypes3, Language.English);
		nurse1.setSchedule(schedule3);

		Patient patient1 = sha.patientsRegisterting("patient1", "patient1", "patient1@email.com", "123", Gender.MALE,
				Location.Montreal, "specailCase");

		Patient patient2 = sha.patientsRegisterting("patient2", "patient2", "patient2@email.com", "123", Gender.MALE,
				Location.Montreal, "specailCase");

		Patient patient3 = sha.patientsRegisterting("patient3", "patient3", "patient3@email.com", "123", Gender.MALE,
				Location.Montreal, "specailCase");

		sha.RequestApp(patient1, Gender.MALE, TimeSlot.From_11_To_1, "", Language.English, TypeOfRequest.SeniorCare,
				"");
		sha.RequestApp(patient1, Gender.FEMALE, TimeSlot.From_1_To_3, "", Language.English, TypeOfRequest.SeniorCare,
				"");
		sha.RequestApp(patient1, Gender.FEMALE, TimeSlot.From_5_To_7, "", Language.English, TypeOfRequest.BooldCar, "");
		sha.RequestApp(patient1, Gender.FEMALE, TimeSlot.From_9_To_11, "", Language.French,
				TypeOfRequest.SurgeryRecoveryCare, "");
		sha.RequestApp(patient2, Gender.MALE, TimeSlot.From_11_To_1, "", Language.English, TypeOfRequest.NewbornCare,
				"");
		sha.RequestApp(patient2, Gender.FEMALE, TimeSlot.From_1_To_3, "", Language.English, TypeOfRequest.SeniorCare,
				"");
		sha.RequestApp(patient2, Gender.FEMALE, TimeSlot.From_5_To_7, "", Language.English,
				TypeOfRequest.SurgeryRecoveryCare, "");
		sha.RequestApp(patient2, Gender.FEMALE, TimeSlot.From_9_To_11, "", Language.French, TypeOfRequest.BooldCar, "");
		sha.RequestApp(patient3, Gender.MALE, TimeSlot.From_11_To_1, "", Language.English, TypeOfRequest.SeniorCare,
				"");
		sha.RequestApp(patient3, Gender.FEMALE, TimeSlot.From_1_To_3, "", Language.English, TypeOfRequest.SeniorCare,
				"");
		sha.RequestApp(patient3, Gender.FEMALE, TimeSlot.From_5_To_7, "", Language.English, TypeOfRequest.BooldCar, "");
		sha.RequestApp(patient3, Gender.FEMALE, TimeSlot.From_9_To_11, "", Language.French,
				TypeOfRequest.SurgeryRecoveryCare, "");
		sha.RequestApp(patient3, Gender.MALE, TimeSlot.From_11_To_1, "", Language.English, TypeOfRequest.NewbornCare,
				"");
		sha.RequestApp(patient3, Gender.FEMALE, TimeSlot.From_1_To_3, "", Language.English, TypeOfRequest.VaccineCare,
				"");
		sha.RequestApp(patient3, Gender.FEMALE, TimeSlot.From_5_To_7, "", Language.English,
				TypeOfRequest.SurgeryRecoveryCare, "");
		sha.RequestApp(patient3, Gender.MALE, TimeSlot.From_3_To_5, "", Language.French, TypeOfRequest.BooldCar, "");

	}

	@Test
	public void testMatching() {
		sha.matchApp();
		sha.viewStatuses();
	}

}

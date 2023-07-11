package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import controller.UserController;
import controller.VehicleList;
import controller.exceptions.AlreadyInGarage;
import controller.exceptions.AlreadyRegistered;
import controller.exceptions.EmptyLicensePlate;
import controller.exceptions.NotInGarage;
import model.StayHistory;
import model.vehicle.OfficialVehicle;
import model.vehicle.ResidentVehicle;
import model.vehicle.Vehicle;

class UserControllerTest {

	@Test
	void testRegisterEntry() {

		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerEntry(null);
		});

		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerEntry("");
		});

		try {
			UserController.registerEntry("ASD1234");
		} catch (AlreadyInGarage | EmptyLicensePlate e) {
			e.printStackTrace();
			fail();
		}

		Vehicle vehicle = VehicleList.getVehicle("ASD1234");

		assertTrue(vehicle.getActualStay().getEntryTime() != null);

		assertThrows(AlreadyInGarage.class, () -> {
			UserController.registerEntry("ASD1234");
		});

	}

	@Test
	void testRegisterExit() {
		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerExit(null);
		});

		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerExit("");
		});

		try {
			UserController.registerEntry("ASD1234");
			UserController.registerExit("ASD1234");
		} catch (NotInGarage | EmptyLicensePlate | AlreadyInGarage e) {
			e.printStackTrace();
			fail("Error");
		}

		Vehicle vehicle = VehicleList.getVehicle("ASD1234");
		assertTrue(vehicle.getActualStay() == null);

		assertThrows(NotInGarage.class, () -> {
			UserController.registerExit("ASD1234");
		});

	}

	@Test
	void testRegisterOficialVehicle() {
		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerOfficialVehicle(null);
		});

		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerOfficialVehicle("");
		});

		try {
			UserController.registerOfficialVehicle("OFI");
		} catch (AlreadyRegistered | EmptyLicensePlate e) {
			fail();
			e.printStackTrace();
		}

		Vehicle vehicle = VehicleList.getVehicle("OFI");

		assertTrue(vehicle != null && vehicle instanceof OfficialVehicle);

	}

	@Test
	void testRegisterResidentVehicle() {
		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerResidentVehicle(null);
		});

		assertThrows(EmptyLicensePlate.class, () -> {
			UserController.registerResidentVehicle("");
		});

		try {
			UserController.registerResidentVehicle("RESI");
		} catch (AlreadyRegistered | EmptyLicensePlate e) {
			fail();
			e.printStackTrace();
		}

		Vehicle vehicle = VehicleList.getVehicle("RESI");

		assertTrue(vehicle != null && vehicle instanceof ResidentVehicle);
	}

	@Test
	void testStartNewMonth() {
		try {
			UserController.registerEntry("NO");
			UserController.registerExit("NO");

			UserController.registerEntry("NO");
			UserController.registerExit("NO");

			UserController.registerOfficialVehicle("OFICIAL");
			UserController.registerEntry("OFICIAL");
			UserController.registerExit("OFICIAL");

			UserController.registerResidentVehicle("RESIDENT");
			UserController.registerEntry("RESIDENT");
			UserController.registerExit("RESIDENT");

		} catch (Exception e) {
			fail();
			e.printStackTrace();
		}

		StayHistory stayHistoryNO = VehicleList.getVehicle("NO").getStayHistory();
		StayHistory stayHistoryOficial = VehicleList.getVehicle("OFICIAL").getStayHistory();
		StayHistory stayHistoryResident = VehicleList.getVehicle("RESIDENT").getStayHistory();

		assertTrue(stayHistoryNO.getStays().size() >= 1);
		assertTrue(stayHistoryOficial.getStays().size() >= 1);
		assertTrue(stayHistoryResident.getStays().size() >= 1);

		UserController.startNewMonth();

		assertTrue(stayHistoryNO.getStays().size() >= 1);
		assertTrue(stayHistoryOficial.getStays().size() == 0);
		assertTrue(stayHistoryResident.getStays().size() == 0);

	}

}

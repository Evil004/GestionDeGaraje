package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import controller.exceptions.AlreadyInGarage;
import controller.exceptions.AlreadyRegistered;
import controller.exceptions.NotInGarage;
import model.PaymentReport;
import model.vehicle.MonthlyReset;
import model.vehicle.NonResidentVehicle;
import model.vehicle.OfficialVehicle;
import model.vehicle.ResidentVehicle;
import model.vehicle.Vehicle;

public class UserController {

	public static void registerEntry(String licensePlate) throws AlreadyInGarage {

		Vehicle vehicle = VehicleList.getVehicle(licensePlate);

		boolean isRegistered = vehicle != null;

		if (!isRegistered) {
			vehicle = new NonResidentVehicle(licensePlate);
			VehicleList.addVehicle(vehicle);

		}

		vehicle.entryAction();

	}

	public static void registerExit(String licensePlate) throws NotInGarage {
		Vehicle vehicle = VehicleList.getVehicle(licensePlate);

		vehicle.exitAction();

	}

	public static void registerOficialVehicle(String licensePlate) throws AlreadyRegistered {
		isRegistered(licensePlate);

		Vehicle oficialVehicle = new OfficialVehicle(licensePlate);

		VehicleList.addVehicle(oficialVehicle);

	}

	public static void registerResidentVehicle(String licensePlate) throws AlreadyRegistered {

		isRegistered(licensePlate);

		Vehicle oficialVehicle = new ResidentVehicle(licensePlate);

		VehicleList.addVehicle(oficialVehicle);

	}

	public static void startNewMonth() {

		VehicleList.getList()
					.stream()
					.filter(v -> v instanceof MonthlyReset)
					.forEach(v -> {
						v.getStayHistory().resetHistory();
					});

	}

	public static String generateMonthlyBill(String fileName) throws IOException {

		ArrayList<Vehicle> vehicles = VehicleList.getList();

		PaymentReport pReport = new PaymentReport(vehicles);

		File reportFile = pReport.generateReport(fileName);

		return reportFile.getCanonicalPath();

	}

	private static void isRegistered(String licensePlate) throws AlreadyRegistered  {
		boolean isVehicleRegistered = VehicleList.getVehicle(licensePlate) != null;

		if (isVehicleRegistered) {
			throw new AlreadyRegistered();
		}
	}

}
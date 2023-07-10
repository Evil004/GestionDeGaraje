package model;

import java.io.File;
import java.util.ArrayList;
import java.util.stream.Collectors;

import controller.ReportGenerator;
import model.vehicle.MonthlyBilledVehicle;
import model.vehicle.Vehicle;

public class PaymentReport {

	private ArrayList<MonthlyBilledVehicle> vehicles;

	public PaymentReport(ArrayList<Vehicle> vehicles) {

		ArrayList<MonthlyBilledVehicle> mbVehicles = new ArrayList<MonthlyBilledVehicle>(
				vehicles.stream()
						.filter(vehicle -> (vehicle instanceof MonthlyBilledVehicle))
						.map(v -> (MonthlyBilledVehicle) v)
						.collect(Collectors.toList()));

		this.vehicles = mbVehicles;
	}

	public File generateReport(String fileName) {

		return ReportGenerator.generateReportFile(vehicles, fileName);

	}

}

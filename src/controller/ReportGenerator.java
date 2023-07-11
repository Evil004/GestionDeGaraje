package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.PaymentReport;
import model.vehicle.MonthlyBilledVehicle;

public class ReportGenerator {

	public static File generateReportFile(PaymentReport payReport, String fileName) {

		ArrayList<MonthlyBilledVehicle> vehicles = payReport.getVehicles();

		File file = null;
		try {

			file = new File(fileName + ".dat");

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			String fileHeader = String.format("%-13s %-30s %-20s\n", "Matrícula", "Tiempo estacionado (min.)",
					"Cantidad a pagar");

			writer.write(fileHeader);

			for (MonthlyBilledVehicle vehicle : vehicles) {
				String vehicleData = vehicle.getMensualBill() + "\n";
				
				writer.write(vehicleData);
			}

			writer.close();

		} catch (Exception e) {
			System.out.println("Error al generar el archivo " + e.getMessage());
		}

		return file;

	}

}

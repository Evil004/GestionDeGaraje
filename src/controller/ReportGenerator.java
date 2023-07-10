package controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

import model.vehicle.MonthlyBilledVehicle;

public class ReportGenerator {

	public static File generateReportFile(ArrayList<MonthlyBilledVehicle> vehicles, String fileName) {

		File file = null;
		try {

			file = new File(fileName + ".dat");

			BufferedWriter writer = new BufferedWriter(new FileWriter(file));

			writer.write(
					String.format("%-13s %-30s %-20s\n", "Matrícula", "Tiempo estacionado (min.)", "Cantidad a pagar"));

			for (MonthlyBilledVehicle vehicle : vehicles) {
				writer.write(vehicle.getMensualBill() + "\n");
			}
			
			writer.close();

		} catch (Exception e) {
			System.out.println("Error al generar el archivo " + e.getMessage());
		}

		return file;

	}

}

package view.console;

import java.io.IOException;

import controller.UserController;
import controller.VehicleList;
import controller.exceptions.AlreadyInGarage;
import controller.exceptions.AlreadyRegistered;
import controller.exceptions.EmptyLicensePlate;
import controller.exceptions.NotInGarage;
import view.View;

public class ConsoleMenu implements View {

	public void startView() {

		boolean flag = true;

		System.out.println(VehicleList.getList());

		while (flag) {
			int option = Utilities
					.getIntegerInput("Que quieres hacer?\n" + "(1) Registrar entrada.\n" + "(2) Registrar salida.\n"
							+ "(3) Dar de alta vehículo oficial.\n" + "(4) Dar de alta vehículo de residente.\n"
							+ "(5) Comenzar mes.\n" + "(6) Generar pagos de residentes.\n" + "(0) Salir.");

			switch (option) {
			case 1:
				registerEntry();
				break;

			case 2:
				registerExit();
				break;

			case 3:
				registerOficialVehicle();
				break;

			case 4:
				registerResidentVehicle();
				break;

			case 5:
				startNewMonth();
				break;

			case 6:
				generateMonthlyBill();
				break;

			case 0:
				flag = false;
				System.out.println("Saliendo.");
				Utilities.closeScanner();
				return;

			default:
				System.out.println("Introduce una opcion correcta, por favor.");
				break;
			}
			Utilities.pauseAndClear();
			

		}
	}

	private static void registerEntry() {

		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo que ha entrado:");

		try {
			UserController.registerEntry(licensePlate);

			System.out.println("Se ha registrado la entrada.");
		} catch (AlreadyInGarage | EmptyLicensePlate e) {
			System.out.println(e.getMessage());
		}

	}

	private static void registerExit() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo que ha entrado:");

		try {
			System.out.println(UserController.registerExit(licensePlate));
			
			Utilities.pauseAndClear();
			
		} catch (NotInGarage | EmptyLicensePlate e) {
			System.out.println(e.getMessage());
		}

	}

	private static void registerOficialVehicle() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo:");

		try {
			UserController.registerOficialVehicle(licensePlate);
			System.out.println("Se ha agregado el vehiculo oficial.");

		} catch (AlreadyRegistered | EmptyLicensePlate e) {

			System.out.println(e.getMessage());

		}
	}

	private static void registerResidentVehicle() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo:");
		try {
			UserController.registerResidentVehicle(licensePlate);

			System.out.println("Se ha agregado el vehiculo del residente.");

		} catch (AlreadyRegistered | EmptyLicensePlate e) {
			System.out.println(e.getMessage());
		}
	}

	private static void startNewMonth() {
		UserController.startNewMonth();
	}

	private static void generateMonthlyBill() {

		String fileName = Utilities.getStringInput("Introduce el nombre con el que se guardara el informe.");

		try {

			String filePath = UserController.generateMonthlyBill(fileName);

			System.out.println("Archivo generado en: " + filePath);

		} catch (IOException e) {
			System.out.println("Error al obtener la ruta del archivo: \n" + e.getMessage());
		}

	}
}

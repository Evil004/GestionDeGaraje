package view;

import java.io.IOException;

import controller.UserController;
import controller.VehicleList;
import controller.exceptions.AlreadyInGarage;
import controller.exceptions.AlreadyRegistered;
import controller.exceptions.NotInGarage;
import utilities.Utilities;

public class MainMenu {

	public static void mainMenu() {

		boolean flag = true;

		System.out.println(VehicleList.getList());

		while (flag) {
			int option = Utilities
					.getIntegerInput("Que quieres hacer?\n" + "(1) Registrar entrada.\n" + "(2) Registrar salida.\n"
							+ "(3) Dar de alta vehículo oficia.\n" + "(4) Dar de alta vehículo de residente.\n"
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
				break;

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
		} catch (AlreadyInGarage e) {
			System.out.println(e.getMessage());
		}

	}

	private static void registerExit() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo que ha entrado:");

		try {
			UserController.registerExit(licensePlate);
			System.out.println("Se ha registrado la salida.");
		} catch (NotInGarage e) {
			System.out.println(e.getMessage());
		}

	}

	private static void registerOficialVehicle() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo:");

		try {
			UserController.registerOficialVehicle(licensePlate);
			System.out.println("Se ha agregado el vehiculo oficial.");

		} catch (AlreadyRegistered e) {

			System.out.println(e.getMessage());

		}
	}

	private static void registerResidentVehicle() {
		String licensePlate = Utilities.getStringInput("Introduce la matricula del vehiculo:");
		try {
			UserController.registerResidentVehicle(licensePlate);

			System.out.println("Se ha agregado el vehiculo del residente.");

		} catch (AlreadyRegistered e) {
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
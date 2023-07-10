package controller;

import java.util.ArrayList;

import model.vehicle.Vehicle;

public class VehicleList {

	private static ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

	public static Vehicle getVehicle(String licencePlate) {
		return vehicles.stream()
					.filter(vehicle -> vehicle.getLicensePlate().equals(licencePlate))
					.findFirst()
					.orElse(null);
	}
	
	public static void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}
	
	public static ArrayList<Vehicle> getList(){
		return vehicles;
	}
}

package model.vehicle;

import controller.StayHistory;
import controller.exceptions.NotInGarage;

public class ResidentVehicle extends MonthlyBilledVehicle {

	private static final float PRICE_MIN = 0.002f;

	public ResidentVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);

		stayHistory = new StayHistory();
	}

	@Override
	public void exitAction() throws NotInGarage {
		if (actualStay == null) {
			throw new NotInGarage();
		}

		actualStay.setExitTime();

		int mins = actualStay.getMins();

		System.out.println("Has estado " + mins + " mins, se han acumulado a la factura mensual.");
		System.out.println(actualStay.getPrice());

		stayHistory.addStay(actualStay);
		actualStay = null;

	}

}

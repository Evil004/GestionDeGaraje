package model.vehicle;

import controller.exceptions.NotInGarage;

public class OfficialVehicle extends Vehicle implements MonthlyReset {

	private static final float PRICE_MIN = 0;

	public OfficialVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);

	}

	@Override
	public void exitAction() throws NotInGarage {

		if (actualStay == null) {
			throw new NotInGarage();
		}

		stayHistory.addStay(actualStay);

		actualStay = null;

		System.out.println("Eres un vehiculo oficial, no se te aplicara ningun cargo.");

	}

	@Override
	public void resetHistory() {
		stayHistory.resetHistory();
		
	}

}

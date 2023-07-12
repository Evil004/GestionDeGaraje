package model.vehicle;

public class OfficialVehicle extends Vehicle implements MonthlyReset {

	private static final float PRICE_MIN = 0;

	public OfficialVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);

	}

	@Override
	public String exitAction() {


		stayHistory.addStay(actualStay);

		actualStay = null;

		return ("Eres un vehiculo oficial, no se te aplicara ningun cargo.");

	}

	@Override
	public void resetHistory() {
		stayHistory.resetHistory();
		
	}

}

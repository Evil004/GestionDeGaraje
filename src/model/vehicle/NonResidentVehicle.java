package model.vehicle;
import controller.exceptions.NotInGarage;

public class NonResidentVehicle extends Vehicle {

	private static final float PRICE_MIN = 0.02f;

	public NonResidentVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);
	}

	@Override
	public String exitAction() throws NotInGarage {
		
		if (actualStay == null) {
			throw new NotInGarage();
		}

		actualStay.setExitTime();
		
		int mins = actualStay.getMins();
		float stayPrice = actualStay.getPrice();


		stayHistory.addStay(actualStay);
		actualStay = null;
		
		return ("Has estado " + mins + " minutos, tienes que pagar " + stayPrice + "€.");

	}


	
	

}

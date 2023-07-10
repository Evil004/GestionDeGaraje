package model.vehicle;
import controller.exceptions.NotInGarage;
import utilities.Utilities;

public class NonResidentVehicle extends Vehicle {

	private static final float PRICE_MIN = 0.02f;

	public NonResidentVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);
	}

	@Override
	public void exitAction() throws NotInGarage {
		
		if (actualStay == null) {
			throw new NotInGarage();
		}

		actualStay.setExitTime();
		
		int mins = actualStay.getMins();
		System.out.println("Has estado " + mins + " minutos, tienes que pagar " + actualStay.getPrice() + "€.");

		stayHistory.addStay(actualStay);
		actualStay = null;
		
		Utilities.pause("Pulsa Enter para pagar...");
	}


	
	

}

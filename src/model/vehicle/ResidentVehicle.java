package model.vehicle;

public class ResidentVehicle extends MonthlyBilledVehicle {

	private static final float PRICE_MIN = 0.002f;
	private static final int MIN_TIME = 0;

	public ResidentVehicle(String licensePlate) {
		super(licensePlate, PRICE_MIN);
	}

	@Override
	public String exitAction()  {
		

		actualStay.setExitTime();

		int mins = actualStay.getMins();

		float stayPrice = actualStay.getPrice();

		if (mins <= MIN_TIME) {
			actualStay.setPriceMin(0);
			
			stayHistory.addStay(actualStay);
			
			actualStay = null;
			return ("La estancia ha sido demasiado corta, no se cobrará nada por ella.");
		}
		stayHistory.addStay(actualStay);


		actualStay = null;

		return "Has estado " + mins + " mins, se han acumulado " + stayPrice + "€ a la factura mensual.";

	}

}

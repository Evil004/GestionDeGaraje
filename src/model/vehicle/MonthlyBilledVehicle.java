package model.vehicle;

import model.Stay;

public abstract class MonthlyBilledVehicle extends Vehicle implements MonthlyReset {
	
	
	
	public MonthlyBilledVehicle(String licensePlate, float priceMin) {
		super(licensePlate, priceMin);
	}
	
	public String getMensualBill() {
		int totalMins = 0;
		float totalPrice = 0;
		
		for (Stay stay : stayHistory.getStays()) {
			
			if (stay.getExitTime() == null || stay.getEntryTime() == null) continue;
			
			totalMins += stay.getMins();
			totalPrice += stay.getPrice();
		}
		
		return String.format("%-13s %-30d %-20.2f", getLicensePlate(), totalMins, totalPrice);
	}

	@Override
	public void resetHistory() {
		stayHistory.resetHistory();
	}
	
}

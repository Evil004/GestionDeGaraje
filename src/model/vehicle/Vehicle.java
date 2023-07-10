package model.vehicle;

import controller.StayHistory;
import controller.exceptions.AlreadyInGarage;
import controller.exceptions.NotInGarage;
import model.Stay;

public abstract class Vehicle {

	protected StayHistory stayHistory = new StayHistory();
	protected Stay actualStay;
	private String licensePlate;
	private float priceMin;

	
	public StayHistory getStayHistory() {
		return stayHistory;
	}

	public Vehicle(String licensePlate, float priceMin) {
		this.licensePlate = licensePlate;
		this.priceMin = priceMin;
	}

	public abstract void exitAction() throws NotInGarage;

	public void entryAction() throws AlreadyInGarage {

		if (actualStay != null) {
			throw new AlreadyInGarage();
		}

		actualStay = new Stay(priceMin);

	};

	public String getLicensePlate() {
		return licensePlate;
	}

	public float getPriceMin() {
		return priceMin;
	}

	public void setPriceMin(float priceMin) {
		this.priceMin = priceMin;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

}

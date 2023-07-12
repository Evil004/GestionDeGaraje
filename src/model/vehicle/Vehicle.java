package model.vehicle;

import model.Stay;
import model.StayHistory;

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

	public abstract String exitAction();

	public boolean entryAction() {

		if (actualStay != null) {
			return false;
		}

		actualStay = new Stay(priceMin);
		return true;

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

	public Stay getActualStay() {
		return actualStay;
	}

}

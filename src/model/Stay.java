package model;

import java.util.Date;

public class Stay {

	private Date entryTime;
	private Date exitTime;
	private float priceMin;

	public Stay(float priceMin) {
		entryTime = new Date(System.currentTimeMillis());
		exitTime = null;
		this.priceMin = priceMin;

	}
	
	public float getDecimalMins() {
		if (entryTime == null) {
			System.out.println("No se ha registrado el tiempo de entrada");
			return 0;
		}
		if (exitTime == null) {
			System.out.println("No se ha registrado el tiempo de salida");
			return 0;
		}

		long diffTime = exitTime.getTime() - entryTime.getTime();

		float mins = (float)diffTime / (60 * 1000);

		return Math.abs(mins);
	}

	public int getMins() {
		

		return (int)getDecimalMins();
	}

	public Date getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(Date entryTime) {
		this.entryTime = entryTime;
	}

	public Date getExitTime() {
		return exitTime;
	}

	public void setExitTime() {
		this.exitTime = new Date(System.currentTimeMillis());
	}
	
	public void setExitTime(Date exitTime) {
		this.exitTime = exitTime;
	}

	public float getFullDecimalPrice() {
		return (float) (priceMin * getDecimalMins());
	}
	
	public float getPrice() {
		
		return (float) (Math.floor(getFullDecimalPrice() * 100) / 100);

	}
	
	public void setPriceMin(float priceMin) {
		this.priceMin = priceMin;
	}

}

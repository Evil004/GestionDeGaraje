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

	public int getMins() {
		if (entryTime == null) {
			System.out.println("No se ha registrado el tiempo de entrada");
			return 0;
		}
		if (exitTime == null) {
			System.out.println("No se ha registrado el tiempo de salida");
			return 0;
		}

		long diffTime = exitTime.getTime() - entryTime.getTime();

		long mins = diffTime / (60 * 1000);

		return (int) Math.abs(mins);
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

	public float getPrice() {
		return (float) (Math.floor((priceMin * getMins()) * 100) / 100);

	}

}

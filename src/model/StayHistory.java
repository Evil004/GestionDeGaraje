package model;

import java.util.ArrayList;

public class StayHistory {

	ArrayList<Stay> stays = new ArrayList<Stay>();

	public void addStay(Stay stay) {
		stays.add(stay);
	}

	public int getTotalMins() {
		
		double mins =  stays.stream().mapToDouble(Stay::getDecimalMins).sum();
		
		return (int) mins ;

	}

	public float getTotalPrice() {

		double totalPrice =stays.stream().mapToDouble(Stay::getFullDecimalPrice).sum();
		
		return (float) (Math.floor(totalPrice * 100) / 100);

	}

	public ArrayList<Stay> getStays() {
		return stays;
	}
	
	public void resetHistory() {
		stays = new ArrayList<Stay>();
	}
}

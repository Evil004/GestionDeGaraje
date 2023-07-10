package controller;

import java.util.ArrayList;

import model.Stay;

public class StayHistory {

	ArrayList<Stay> stays = new ArrayList<Stay>();

	public void addStay(Stay stay) {
		stays.add(stay);
	}

	public int getTotalMins() {

		return stays.stream().mapToInt(Stay::getMins).sum();

	}

	public float getTotalPrice() {

		return (float) stays.stream().mapToDouble(Stay::getPrice).sum();

	}

	public ArrayList<Stay> getStays() {
		return stays;
	}
	
	public void resetHistory() {
		stays = new ArrayList<Stay>();
	}
}

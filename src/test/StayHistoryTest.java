package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.Stay;
import model.StayHistory;

class StayHistoryTest {

	@Test
	void testGetTotalMins() {
		StayHistory stayHistory = new StayHistory();

		Stay testStay = new Stay(0.02f);

		testStay.setEntryTime(new Date(0));
		testStay.setExitTime(new Date(65742));

		stayHistory.addStay(testStay);

		Stay testStay2 = new Stay(0.02f);

		testStay2.setEntryTime(new Date(0));
		testStay2.setExitTime(new Date(512583));
		stayHistory.addStay(testStay2);
		Stay testStay3 = new Stay(0.02f);

		testStay3.setEntryTime(new Date(0));
		testStay3.setExitTime(new Date(1253181));
		stayHistory.addStay(testStay3);

		Stay testStay5 = new Stay(0.02f);

		testStay5.setEntryTime(new Date(0));
		testStay5.setExitTime(new Date(3251864));
		stayHistory.addStay(testStay5);

		Stay testStay6 = new Stay(0.02f);
		testStay6.setEntryTime(new Date(0));
		testStay6.setExitTime(new Date(916900));
		stayHistory.addStay(testStay6);

		assertEquals(100, stayHistory.getTotalMins());

	}

	@Test
	void testGetTotalPrice() {
		StayHistory stayHistory = new StayHistory();

		Stay testStay = new Stay(0.02f);

		testStay.setEntryTime(new Date(0));
		testStay.setExitTime(new Date(65742));

		stayHistory.addStay(testStay);

		Stay testStay2 = new Stay(0.02f);

		testStay2.setEntryTime(new Date(0));
		testStay2.setExitTime(new Date(512583));
		stayHistory.addStay(testStay2);
		Stay testStay3 = new Stay(0.02f);

		testStay3.setEntryTime(new Date(0));
		testStay3.setExitTime(new Date(1253181));
		stayHistory.addStay(testStay3);

		Stay testStay5 = new Stay(0.02f);

		testStay5.setEntryTime(new Date(0));
		testStay5.setExitTime(new Date(3251864));
		stayHistory.addStay(testStay5);

		Stay testStay6 = new Stay(0.02f);
		testStay6.setEntryTime(new Date(0));
		testStay6.setExitTime(new Date(916900));
		stayHistory.addStay(testStay6);

		assertEquals(2, stayHistory.getTotalPrice());

	}

	@Test
	void testResetHistory() {
		StayHistory stayHistory = new StayHistory();

		Stay testStay = new Stay(0.02f);

		testStay.setEntryTime(new Date(0));
		testStay.setExitTime(new Date(65742));

		stayHistory.addStay(testStay);

		Stay testStay2 = new Stay(0.02f);

		testStay2.setEntryTime(new Date(0));
		testStay2.setExitTime(new Date(512583));
		stayHistory.addStay(testStay2);
		Stay testStay3 = new Stay(0.02f);

		testStay3.setEntryTime(new Date(0));
		testStay3.setExitTime(new Date(1253181));
		stayHistory.addStay(testStay3);

		Stay testStay5 = new Stay(0.02f);

		testStay5.setEntryTime(new Date(0));
		testStay5.setExitTime(new Date(3251864));
		stayHistory.addStay(testStay5);

		Stay testStay6 = new Stay(0.02f);
		testStay6.setEntryTime(new Date(0));
		testStay6.setExitTime(new Date(916900));
		stayHistory.addStay(testStay6);

		assertTrue(stayHistory.getStays().size()>0);
		
		stayHistory.resetHistory();
		
		assertTrue(stayHistory.getStays().size()==0);
		
	}

}

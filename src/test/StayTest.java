package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Test;

import model.Stay;

class StayTest {

	@Test
	void testGetMins() {

		Stay testStay = new Stay(1);

		testStay.setEntryTime(new Date(0));
		testStay.setExitTime(new Date(600000));

		assertEquals(10, testStay.getMins());

		Stay testStay2 = new Stay(1);

		testStay2.setEntryTime(new Date(600000));
		testStay2.setExitTime(new Date(0));

		assertEquals(10, testStay2.getMins());

		Stay testStay3 = new Stay(1);

		testStay3.setEntryTime(new Date(0));
		testStay3.setExitTime(new Date(0));

		assertEquals(0, testStay3.getMins());
	}

	@Test
	void testGetPrice() {
		Stay testStay = new Stay(0.5f);

		testStay.setEntryTime(new Date(0));
		testStay.setExitTime(new Date(600000));

		assertEquals(5, testStay.getPrice());

		Stay testStay2 = new Stay(0.5f);

		testStay2.setEntryTime(new Date(600000));
		testStay2.setExitTime(new Date(0));

		assertEquals(5, testStay2.getPrice());

		Stay testStay3 = new Stay(0.5f);

		testStay3.setEntryTime(new Date(0));
		testStay3.setExitTime(new Date(0));

		assertEquals(0, testStay3.getPrice());
	}
}

package controller.exceptions;

public class EmptyLicensePlate extends Exception {

	private static final String DEFAULT_MESSAGE = "La matricula no puede estár vacía";

	public EmptyLicensePlate() {
		super(DEFAULT_MESSAGE);
	}

	public EmptyLicensePlate(String message) {
		super(message);
	}
}

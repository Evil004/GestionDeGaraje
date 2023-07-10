package controller.exceptions;

public class AlreadyInGarage extends Exception {

	private static final String DEFAULT_MESSAGE = "El vehiculo ya está en el garaje";

	public AlreadyInGarage() {
		super(DEFAULT_MESSAGE);
	}

	public AlreadyInGarage(String message) {
		super(message);
	}

}

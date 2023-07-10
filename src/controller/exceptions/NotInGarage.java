package controller.exceptions;

public class NotInGarage extends Exception {

	private static final String DEFAULT_MESSAGE = "El vehiculo no está dentro del garaje";

	public NotInGarage() {
		super(DEFAULT_MESSAGE);
	}

	public NotInGarage(String message) {
		super(message);
	}

}

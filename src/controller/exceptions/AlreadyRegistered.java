package controller.exceptions;

public class AlreadyRegistered extends Exception {

	private static final String DEFAULT_MESSAGE = "Ese vehiculo ya está registrado ha registrado.";

	public AlreadyRegistered() {
		super(DEFAULT_MESSAGE);
	}

	public AlreadyRegistered(String message) {
		super(message);
	}

}

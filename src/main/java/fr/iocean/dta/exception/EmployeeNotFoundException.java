package fr.iocean.dta.exception;

public class EmployeeNotFoundException extends Exception {

	private static final long serialVersionUID = -346242457652131406L;

	public EmployeeNotFoundException() {
	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}
}

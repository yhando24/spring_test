package fr.iocean.dta.exception;

import org.springframework.stereotype.Component;


public class EmployeeNotFoundException extends Exception {

	
	public EmployeeNotFoundException( ) {
	}
	
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}

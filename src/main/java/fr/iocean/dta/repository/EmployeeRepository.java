package fr.iocean.dta.repository;

import java.util.List;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;

public interface EmployeeRepository {

	void saveEmployee(Employe employe);

	List<Employe> findAllEmployes();

	Employe findBySsn(String ssn) throws EmployeeNotFoundException;

	void updateEmployee(Employe employe);
	
	void deleteEmploye(int id);
	
	void updateAll(List <Employe> employes);
}

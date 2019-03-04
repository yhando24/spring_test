package fr.iocean.dta.service;

import java.util.List;

import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;

public interface EmployeService {
	void saveEmployee(Employe employe);

	List<Employe> findAllEmployees();

	Employe findBySsn(String ssn);

	void updateEmployee(Employe employe);

	Employe findLastHired();
	
	void deleteEmploye(int id);
	
	void updateAll(List <Employe> employes);

}

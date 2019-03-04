package fr.iocean.dta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import fr.iocean.dta.exception.EmployeeNotFoundException;
import fr.iocean.dta.exception.ErrorUpdateException;
import fr.iocean.dta.model.Employe;
import fr.iocean.dta.repository.EmployeeRepository;

@Service
public class EmployeeJdbcService implements EmployeService {

	@Autowired
	private EmployeeRepository employeeJdbcRepository;

	@Override
	public void saveEmployee(Employe employe) {
		employeeJdbcRepository.saveEmployee(employe);
	}

	@Override
	public List<Employe> findAllEmployees() {
		List<Employe> e = employeeJdbcRepository.findAllEmployes();
		return e;
	}

	@Override
	public Employe findBySsn(String ssn) {
		try {
			return employeeJdbcRepository.findBySsn(ssn);
		} catch (EmployeeNotFoundException e) {
			return null;
		}
	}

	@Override
	public void updateEmployee(Employe employe) {
		employeeJdbcRepository.updateEmployee(employe);
	}

	@Override
	public Employe findLastHired() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteEmploye(int id) {
		employeeJdbcRepository.deleteEmploye(id);

	}

	@Override
	@Transactional(rollbackFor = ErrorUpdateException.class)
	public void updateAll(List<Employe> employes) {
		employeeJdbcRepository.updateAll(employes);
		throw new ErrorUpdateException("Erreur update");

	}

}
